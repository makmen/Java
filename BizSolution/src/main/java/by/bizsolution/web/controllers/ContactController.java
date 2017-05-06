package by.bizsolution.web.controllers;

import by.bizsolution.web.models.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by AMakas on 21.04.2017.
 */
@Controller
@RequestMapping(value = "/contact")
public class ContactController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView contact(Model model) {
        Contact contact = new Contact();
        // check session

        model.addAttribute("contact", contact);
        model.addAttribute("template", "contact/contact");

        return new ModelAndView("index");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView contact(@Valid Contact contact,
                                BindingResult bindingResult,
                                Model model
    ) {
/*
        for (Object object : bindingResult.getAllErrors()) {
            if (object instanceof FieldError) {
                FieldError fieldError = (FieldError) object;

                System.out.println(fieldError.getField() + ":"
                        + fieldError.getCode());

            }

            if (object instanceof ObjectError) {
                ObjectError objectError = (ObjectError) object;

            }
        }
*/
        System.out.println(contact);
        System.out.println(bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult);
        } else {
            if ( true ) { // send email
                model.addAttribute("success", "Данные отправлены");
                //contact = new Contact();
            } else {
                model.addAttribute("error", "Ошибка отправки данных");
            }
        }
        model.addAttribute("contact", contact);
        model.addAttribute("template", "contact/contact");

        return new ModelAndView("index");
    }
}
