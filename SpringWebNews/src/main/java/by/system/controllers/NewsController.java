package by.system.controllers;

import by.db.repository.NewsRepository;
import by.lib.Number;
import by.system.models.Account;
import by.system.models.News;
import by.system.models.NewsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by AMakas on 06.03.2017.
 */
@Controller
public class NewsController {

    private NewsRepository newsRepository;
    public NewsController() {
        newsRepository = new NewsRepository();
    }

    @Autowired
    private NewsValidator newsValidator;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "p", required = false) String p,
                              Model model) {
        int page = getNeedPage(p);
        int offset = (page - 1) * newsRepository.getLimit();
        List<News> allNews = newsRepository.getAllLimit( offset );
        for ( News item: allNews ) {
            if (item.getText().length() > 50) {
                item.setText( item.getText().substring(0, 50) );
            }
        }

        model.addAttribute("totalPages", getTotalPages());
        model.addAttribute("page", page);
        model.addAttribute("allNews", allNews);
        model.addAttribute("template", "news/index");

        return new ModelAndView("index");
    }

    private int getNeedPage(String p) {
        int out = 1;
        StringBuilder error = new StringBuilder("");
        if (p == null) {
            return out;
        }
        out = Number.getInt(p, error);
        if (!error.toString().equals("")) {
            out = 1;
        }

        return out;
    }

    private int getTotalPages() {
        int totalNews = newsRepository.getTotalNews();
        return (int)Math.ceil((double) totalNews / (double)newsRepository.getLimit());
    }

    @RequestMapping(value = "/news/viewone/{id:[\\d]+}", method = RequestMethod.GET)
    public ModelAndView viewOne(@PathVariable("id") int id,
                                Model model, HttpSession httpSession) {
        Account accountIn = AccountController.getSessionAccount(httpSession);
        News news = newsRepository.getById( id );
        if (news != null && accountIn != null) {
            if (news.getAccount().getId() == accountIn.getId()) {
                model.addAttribute("canEdit", true);
            }
        }

        model.addAttribute("news", news);
        model.addAttribute("template", "news/viewone");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/news/print/{id:[\\d]+}", method = RequestMethod.GET)
    public ModelAndView print(@PathVariable("id") int id,
                              Model model) {
        News news = newsRepository.getById( id );
        model.addAttribute("news", news);

        return new ModelAndView("news/print");
    }

    @RequestMapping(value = "/news/edit/{id:[\\d]+}", method = RequestMethod.GET)
    public ModelAndView newsEdit(@PathVariable("id") int id,
                                 Model model, HttpSession httpSession) {
        Account accountIn = AccountController.getSessionAccount(httpSession);
        if (accountIn == null) {
            return new ModelAndView("redirect:/");
        }
        News news = newsRepository.getById( id );
        if (news == null || news.getAccount().getId() != accountIn.getId()) {
            return new ModelAndView("redirect:/");
        }
        model.addAttribute("url", "/news/edit/" + id);
        model.addAttribute("news", news);
        model.addAttribute("template", "news/add");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/news/edit/{id:[\\d]+}", method = RequestMethod.POST)
    public ModelAndView newsEdit(@PathVariable("id") int id,
                                 @ModelAttribute() News news,
                                 BindingResult bindingResult,
                                 Model model, HttpSession httpSession) {
        Account accountIn = AccountController.getSessionAccount(httpSession);
        if (accountIn == null) {
            return new ModelAndView("redirect:/");
        }
        System.out.println( id );
        News oldNews = newsRepository.getById( id );
        if (news == null || oldNews.getAccount().getId() != accountIn.getId()) {
            return new ModelAndView("redirect:/");
        }
        newsValidator.validate(news, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult);
        } else {
            // add date into Base
            news.setId( oldNews.getId() );
            news.setRegisted( oldNews.getRegisted() );
            news.setUpdated( new Date() );
            news.setAccount( accountIn );
            if ( newsRepository.set( news ) ) {
                return new ModelAndView("redirect:/news");
            } else {
                model.addAttribute("error", "Ошибка вставки в базу");
            }
        }
        model.addAttribute("url", "/news/edit/" + id);
        model.addAttribute("news", news);
        model.addAttribute("template", "news/add");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/news/add", method = RequestMethod.GET)
    public ModelAndView newsAdd(Model model, HttpSession httpSession) {
        Account accountIn = AccountController.getSessionAccount(httpSession);
        if (accountIn == null) {
            return new ModelAndView("redirect:/");
        }
        model.addAttribute("url", "/news/add");
        model.addAttribute("template", "news/add");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/news/add", method = RequestMethod.POST)
    public ModelAndView newsAdd(@ModelAttribute() News news,
                                BindingResult bindingResult,
                                Model model,
                                HttpSession httpSession) {
        Account accountIn = AccountController.getSessionAccount(httpSession);
        if (accountIn == null) {
            return new ModelAndView("redirect:/");
        }
        newsValidator.validate(news, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult);
        } else {
            // add date into Base
            news.setAccount( accountIn );
            news.setRegisted( new Date() );
            news.setUpdated( new Date() );

            if ( newsRepository.set( news ) ) {
                return new ModelAndView("redirect:/news");
            } else {
                model.addAttribute("error", "Ошибка вставки в базу");
            }
        }
        model.addAttribute("url", "/news/add");
        model.addAttribute("news", news);
        model.addAttribute("template", "news/add");

        return new ModelAndView("index");
    }

}
