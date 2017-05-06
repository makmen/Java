package by.begin.controllers;

import by.lib.Number;
import by.lib.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AMakas on 28.02.2017.
 */
@Controller
public class CalcController {
    private Map<String, String> outAttribute = new HashMap<String, String>();
    private Map<String, String> outErrors = new HashMap<String, String>();

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public ModelAndView calculator(Model model) {
        outErrors.clear();
        outAttribute.clear();

        return new ModelAndView("calculator");
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public ModelAndView calculator(@RequestParam(value="first", required=true) String first,
                                   @RequestParam(value="operation", required=true) String operation,
                                   @RequestParam(value="second", required=true) String second, Model model) {
        outErrors.clear();
        outAttribute.clear();
        ModelAndView modelAndView = new ModelAndView("calculator");
        double firstDouble = checkDoubleParam( "first", first );
        double secondDouble = checkDoubleParam( "second", second );
        if (outErrors.size() == 0) { // ошибок нету
            Operation operate = defineOperation( operation );
            if ( operation != null ) {
                outAttribute.put("result", Double.toString( operate.calculation(firstDouble, secondDouble) ));
            }
        }
        model.addAttribute("outAttribute", outAttribute);
        model.addAttribute("outErrors", outErrors);

        return modelAndView;
    }

    private Operation defineOperation(String value) {
        outAttribute.put("operation", value);
        Operation operation= new Operation();
        if (value.equals("mul")) {
            operation.setStrategy(new OperationMultiplication());
        } else if(value.equals("div")) {
            operation.setStrategy(new OperationDivision());
        } else if(value.equals("add")) {
            operation.setStrategy(new OperationAddition());
        } else  {
            operation.setStrategy(new OperationSubtraction());
        }

        return operation;
    }

    private double checkDoubleParam(String key, String value) {
        outAttribute.put(key, value);
        StringBuilder error = new StringBuilder("");
        double out = Number.getDouble(value, error);
        if (!error.toString().equals("")) {
            outErrors.put(key, error.toString());
        }

        return out;
    }

}
