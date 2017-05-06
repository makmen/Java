package by.begin.controllers;

import by.begin.models.Anketa;
import by.begin.models.AnketaValidator;
import by.db.dao.AnketaRepository;
import by.db.dao.daoi.IAnketa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMakas on 28.02.2017.
 */
@Controller
public class AnketaController {

    @Autowired
    AnketaValidator anketaValidator;

    private List<String> counties = new ArrayList<String>();
    private List<String> ages = new ArrayList<String>();
    private IAnketa anketaRepository;

    public AnketaController() {
        counties.add("Беларусь");
        counties.add("Россия");
        counties.add("Украина");
        for (int i = 5; i < 100; i++) {
            ages.add(Integer.toString(i));
        }
        anketaRepository = new AnketaRepository();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView newAccount(Model model) {
        ModelAndView modelAndView = new ModelAndView("anketa/_anketa");
        model.addAttribute("counties", counties);
        model.addAttribute("ages", ages);
        Anketa anketa = new Anketa();
        modelAndView.addObject("anketa", anketa);

        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView newAccount(@ModelAttribute() Anketa anketa,
                                   BindingResult bindingResult,
                                   Model model) {
        ModelAndView modelAndView = new ModelAndView("anketa/_anketa");
        anketaValidator.validate(anketa, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult);
        } else {
            // add date into Base
            if ( anketaRepository.set(anketa) ) {
                model.addAttribute("success", "Данные сохранены");
                anketa = new Anketa();
                modelAndView.addObject("anketa", anketa);
            } else {
                model.addAttribute("error", "Ошибка вставки в базу");
            }
        }

        model.addAttribute("counties", counties);
        model.addAttribute("ages", ages);

        return modelAndView;
    }

}
