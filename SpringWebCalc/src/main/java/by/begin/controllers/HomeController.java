package by.begin.controllers;


import by.begin.models.Account;
import by.begin.models.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;


/**
 * Created by admin on 25.02.2017.
 */
@Controller
public class HomeController {

    @Autowired
    AccountValidator validator;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView newAccount(Model model) {
        ModelAndView modelAndView = new ModelAndView("account");
        Account account = new Account();
        account.setAge(20);
        modelAndView.addObject("accountform", account);

        return modelAndView;
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ModelAndView newAccount(@ModelAttribute("accountform") Account account,
                                   BindingResult bindingResult, Model model) {
        validator.validate(account, bindingResult);

        if (bindingResult.hasErrors()) {
            System.out.println("Errors");
        } else {
            System.out.println("Good");
        }

        ModelAndView modelAndView = new ModelAndView("account");
        modelAndView.addObject("account", account);

        return modelAndView;
    }




}
