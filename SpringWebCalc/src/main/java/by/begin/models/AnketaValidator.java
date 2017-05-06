package by.begin.models;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AMakas on 28.02.2017.
 */
@Component
public class AnketaValidator implements Validator {

    public boolean supports(Class clazz) {
        return Anketa.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {

        Anketa anketa = (Anketa) target;

        emptyAndSizeLimit("name", anketa.getName(), errors, 255);
        emptyAndSizeLimit("surname", anketa.getSurname(), errors, 255);
        emptyAndSizeLimit("lastname", anketa.getLastname(), errors, 255);
        emptyAndSizeLimit("email", anketa.getEmail(), errors, 255);
        if ( !errors.hasFieldErrors("email") ) {
            Pattern pattern = Pattern.compile("^[0-9a-z_\\.-]+@[0-9a-z_\\.-]+\\.[a-z]{2,}?$");
            if ( !pattern.matcher(anketa.getEmail()).matches() ) {
                errors.rejectValue("email", "Wrong format for the field");
            }
        }
        emptyAndSizeLimit("login", anketa.getLogin(), errors, 255);
        if ( !errors.hasFieldErrors("login") ) {
            Pattern pattern = Pattern.compile("^[a-zA-Z]{2,}$");
            if ( !pattern.matcher(anketa.getLogin()).matches() ) {
                errors.rejectValue("login", "Wrong format for the field");
            }
        }
        emptyAndSizeLimit("password", anketa.getPassword(), errors, 255);
        emptyAndSizeLimit("repassword", anketa.getRepassword(), errors, 255);
        if ( !errors.hasFieldErrors("password") && !errors.hasFieldErrors("repassword") ) {
            if ( !anketa.getPassword().equals(anketa.getRepassword()) ) {
                errors.rejectValue("password", "Passwords have to be the same");
                errors.rejectValue("repassword", "Passwords have to be the same");
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
