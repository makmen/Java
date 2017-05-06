package by.system.controllers;

import by.system.models.Account;
import by.system.models.Contact;
import by.system.models.ContactValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


/**
 * Created by admin on 25.02.2017.
 */
@Controller
public class HomeController {

    @Autowired
    private ContactValidator contactValidator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "loginerror", required = false) String loginerror,
                              Model model) {
        if (loginerror != null) {
            model.addAttribute("loginerror", "true");
        }
        model.addAttribute("template", "home/index");
        return new ModelAndView("index");
    }


    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public ModelAndView contacts(Model model, HttpSession httpSession) {
        Account account = AccountController.getSessionAccount(httpSession);
        Contact contact = new Contact();
        if (account != null) {
            contact.setName( account.getName() + " " + account.getLastname() + " " + account.getSurname() );
            contact.setEmail( account.getEmail() );
        }
        model.addAttribute("contact", contact);
        model.addAttribute("template", "home/сontacts");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public ModelAndView contacts(@ModelAttribute() Contact contact,
                                 BindingResult bindingResult,
                                 Model model) {
        contactValidator.validate(contact, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult);
        } else {
            if ( true ) { // send email
                model.addAttribute("success", "Данные отправлены");
                contact = new Contact();
            } else {
                model.addAttribute("error", "Ошибка отправки данных");
            }
        }
        model.addAttribute("contact", contact);
        model.addAttribute("template", "home/сontacts");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/technology", method = RequestMethod.GET)
    public ModelAndView technology(Model model) {

        model.addAttribute("template", "home/technology");
        return new ModelAndView("index");
    }


}
