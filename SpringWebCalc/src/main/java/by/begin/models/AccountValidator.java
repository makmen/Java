package by.begin.models;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by AMakas on 27.02.2017.
 */
@Component
public class AccountValidator implements Validator {

    public boolean supports(Class clazz) {
        return Account.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "error.fullName", "Full name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "error.login", "Login is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Password is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "error.age", "Age is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");


    }

}
