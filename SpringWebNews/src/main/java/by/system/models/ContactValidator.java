package by.system.models;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

/**
 * Created by AMakas on 28.02.2017.
 */
@Component
public class ContactValidator implements Validator {

    public boolean supports(Class clazz) {
        return Contact.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        Contact contact = (Contact)target;
        emptyAndSizeLimit("name", contact.getName(), errors, 255);
        emptyAndSizeLimit("email", contact.getEmail(), errors, 255);
        if ( !errors.hasFieldErrors("email") ) {
            Pattern pattern = Pattern.compile("^[0-9a-z_\\.-]+@[0-9a-z_\\.-]+\\.[a-z]{2,}?$");
            if ( !pattern.matcher(contact.getEmail()).matches() ) {
                errors.rejectValue("email", "Wrong format for the field");
            }
        }
        emptyAndSizeLimit("message", contact.getMessage(), errors, 1000);
    }

    private void emptyAndSizeLimit(String name, String target, Errors errors, int limit) {
        if( target.equals("") ){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, name, "Field is required");
        } else if (target.length() >= limit) {
            errors.rejectValue(name, "Wrong format for the field");
        }
    }
}
