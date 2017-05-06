package by.system.controllers;

import by.db.repository.AccountRepository;
import by.db.repository.CountryRepository;
import by.system.models.Account;
import by.system.models.AccountValidator;
import by.system.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AMakas on 06.03.2017.
 */
@Controller
public class AccountController {

    @Autowired
    private AccountValidator accountValidator;

    private List<Country> countries;
    private List<String> ages = new ArrayList<String>();
    private AccountRepository accountRepository;
    private CountryRepository countryRepository;

    public AccountController() {
        countryRepository = new CountryRepository();
        accountRepository = new AccountRepository();
        countries = countryRepository.getAll();
        for (int i = 5; i < 100; i++) {
            ages.add(Integer.toString(i));
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(Model model, HttpSession httpSession) {
        Account account = this.getSessionAccount(httpSession);
        // redirect to update account

        model.addAttribute("countries", countries);
        model.addAttribute("ages", ages);
        model.addAttribute("account", account);
        model.addAttribute("template", "account/register");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerAdd(@ModelAttribute() Account account,
                                 BindingResult bindingResult,
                                 Model model,
                                 HttpSession httpSession) {
        Account accountIn = this.getSessionAccount(httpSession);
        accountValidator.setAccountRepository(accountRepository);
        if (accountIn != null) {
            accountValidator.setMode("edit");
            account.setId( accountIn.getId() );
            account.setLogin( accountIn.getLogin() );
            account.setPassword( accountIn.getPassword() );
        }
        accountValidator.validate(account, bindingResult);
        account.setCountry( countryRepository.getByAbbr( account.getCountryabbr() ) );

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult);
        } else {
            // add date into Base
            if ( accountRepository.set( account ) ) {
                model.addAttribute("success", "Данные сохранены");
                httpSession.setAttribute("accountIn", account);
            } else {
                model.addAttribute("error", "Ошибка вставки в базу");
            }
        }
        model.addAttribute("countries", countries);
        model.addAttribute("ages", ages);
        model.addAttribute("account", account);
        model.addAttribute("template", "account/register");

        return new ModelAndView("index");
    }

    public static Account getSessionAccount(HttpSession httpSession) {
        return (Account)httpSession.getAttribute("accountIn");
    }

    @RequestMapping(value = "/register/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.invalidate();

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/register/check", method = RequestMethod.POST)
    public ModelAndView check(@RequestParam(value="login", required=true) String login,
                              @RequestParam(value="password", required=true) String password,
                              HttpSession httpSession) {
        ModelAndView modelAndView =  new ModelAndView("redirect:/");
        if (login.toString().equals("") || password.toString().equals("") ) {
            modelAndView.addObject("loginerror", "true");
        } else {
            Account account = accountRepository.getAccount(login,password);
            if (account != null) {
                httpSession.setAttribute("accountIn", account);
            } else {
                modelAndView.addObject("loginerror", "true");
            }
        }

        return modelAndView;
    }

    @RequestMapping(value = "/register/change", method = RequestMethod.GET)
    public ModelAndView change(Model model, HttpSession httpSession) {
        Account accountIn = this.getSessionAccount(httpSession);
        if (accountIn == null) {
            return new ModelAndView("redirect:/");
        }
        model.addAttribute("template", "account/change");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/register/change", method = RequestMethod.POST)
    public ModelAndView change(@RequestParam(value="oldpassword", required=true) String oldpassword,
                               @RequestParam(value="password", required=true) String password,
                               @RequestParam(value="repassword", required=true) String repassword,
                               Model model,
                               HttpSession httpSession) {
        Account accountIn = this.getSessionAccount(httpSession);
        if (accountIn == null) {
            return new ModelAndView("redirect:/");
        }
        Map<String, String> errors = new HashMap<String, String>();
        checkEmpty(oldpassword, "oldpassword", errors);
        checkEmpty(password, "password", errors);
        checkEmpty(repassword, "repassword", errors);

        if (errors.size() == 0) {
            if ( !accountIn.getPassword().equals( oldpassword ) ) {
                errors.put("oldpassword", "Password is wrong");
            }
            if ( !password.equals( repassword ) ) {
                errors.put("password", "Passwords have to be the same");
                errors.put("repassword", "Passwords have to be the same");
            }
        }

        if (errors.size() == 0) {
            accountIn.setPassword( password );
            if ( accountRepository.set( accountIn ) ) {
                model.addAttribute("success", "Данные сохранены");
                httpSession.setAttribute("accountIn", accountIn);
            } else {
                model.addAttribute("error", "Ошибка вставки в базу");
            }
        }

        model.addAttribute("errors", errors);
        model.addAttribute("template", "account/change");

        return new ModelAndView("index");
    }

    private void checkEmpty(String value, String key,  Map<String, String> errors) {
        if ( value.toString().equals(""))  {
            errors.put(key, "Field is required");
        }
    }


}
