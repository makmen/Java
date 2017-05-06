package by.system.models;

import by.db.repository.AccountRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

/**
 * Created by AMakas on 28.02.2017.
 */
@Component
public class AccountValidator implements Validator {

    private String mode = "add";
    public void setMode(String mode) {
        this.mode = mode;
    }

    private AccountRepository accountRepository;
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean supports(Class clazz) {
        return Account.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {

        Account account = (Account)target;

        emptyAndSizeLimit("name", account.getName(), errors, 255);
        emptyAndSizeLimit("surname", account.getSurname(), errors, 255);
        emptyAndSizeLimit("lastname", account.getLastname(), errors, 255);
        emptyAndSizeLimit("email", account.getEmail(), errors, 255);
        if ( !errors.hasFieldErrors("email") ) {
            Pattern pattern = Pattern.compile("^[0-9a-z_\\.-]+@[0-9a-z_\\.-]+\\.[a-z]{2,}?$");
            if ( !pattern.matcher(account.getEmail()).matches() ) {
                errors.rejectValue("email", "Wrong format for the field");
            }
        }
        if (mode == "add") {
            emptyAndSizeLimit("login", account.getLogin(), errors, 255);
            if ( !errors.hasFieldErrors("login") ) {
                Pattern pattern = Pattern.compile("^[a-zA-Z]{2,}$");
                if ( !pattern.matcher(account.getLogin()).matches() ) {
                    errors.rejectValue("login", "Wrong format for the field");
                } else if ( accountRepository.getByLogin( account.getLogin() ) != null ) {
                    errors.rejectValue("login", "Login already exists in the system");
                }
            }
            emptyAndSizeLimit("password", account.getPassword(), errors, 255);
            emptyAndSizeLimit("repassword", account.getRepassword(), errors, 255);
            if ( !errors.hasFieldErrors("password") && !errors.hasFieldErrors("repassword") ) {
                if ( !account.getPassword().equals(account.getRepassword()) ) {
                    errors.rejectValue("password", "Passwords have to be the same");
                    errors.rejectValue("repassword", "Passwords have to be the same");
                }
            }
        }
    }

    private void emptyAndSizeLimit(String name, String target, Errors errors, int limit) {
        if( target.equals("") ){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, name, "Field is required");
        } else if (target.length() >= limit) {
            errors.rejectValue(name, "Wrong format for the field");
        }
    }
}
