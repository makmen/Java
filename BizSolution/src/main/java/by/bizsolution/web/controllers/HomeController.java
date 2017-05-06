package by.bizsolution.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(Model model) {

        model.addAttribute("template", "home/index");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/support", method = RequestMethod.GET)
    public ModelAndView support(Model model) {

        model.addAttribute("template", "home/support");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about(Model model) {

        model.addAttribute("template", "home/about");

        return new ModelAndView("index");
    }

}
