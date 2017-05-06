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
public class NewsValidator implements Validator {

    private String mode = "add";
    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean supports(Class clazz) {
        return News.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        News news = (News)target;
        emptyAndSizeLimit("title", news.getTitle(), errors, 255);
        emptyAndSizeLimit("text", news.getText(), errors, 1000);
    }

    private void emptyAndSizeLimit(String name, String target, Errors errors, int limit) {
        if( target.equals("") ){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, name, "Field is required");
        } else if (target.length() >= limit) {
            errors.rejectValue(name, "Wrong format for the field");
        }
    }
}
