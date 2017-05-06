package by.begin.controllers;

import by.lib.Checker;
import by.lib.Number;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AMakas on 28.02.2017.
 */

@Controller
public class ShapeController {
    private List<String> outErrors = new ArrayList<String>();
    private Map<String, String> outAttribute = new HashMap<String, String>();

    @RequestMapping(value = "/shape", method = RequestMethod.GET)
    public ModelAndView shape(Model model) {
        outErrors.clear();
        outAttribute.clear();
        return new ModelAndView("shapes");
    }

    @RequestMapping(value = "/shape", method = RequestMethod.POST)
    public ModelAndView shape(@RequestParam(value="shape", required=true) String shape, Model model) {
        outErrors.clear();
        outAttribute.clear();
        StringBuilder error = new StringBuilder("");
        int num = Number.getInt(shape, error);
        if (error.toString().equals("")) {
            switch (num) {
                case 1: // круг
                    return new ModelAndView("redirect:/circle");
                case 2: // прямоугольник
                    return new ModelAndView("redirect:/rectangle");
                case 3: // квадрат
                    return new ModelAndView("redirect:/square");
                default: // треугольник
                    return new ModelAndView("redirect:/triangle");
            }
        }

        return new ModelAndView("shape");
    }

    @RequestMapping(value = "triangle", method = RequestMethod.GET)
    public ModelAndView shapeTriangle(Model model) {
        outErrors.clear();
        outAttribute.clear();
        return new ModelAndView("triangle");
    }

    @RequestMapping(value = "triangle", method = RequestMethod.POST)
    public ModelAndView shapeTriangle(@RequestParam(value="first", required=true) String first,
                                      @RequestParam(value="second", required=true) String second,
                                      @RequestParam(value="third", required=true) String third,
                                      Model model) {
        outErrors.clear();
        outAttribute.clear();
        double firstDouble = Checker.checkDoubleParam( "first", first, outErrors, outAttribute );
        double secondDouble = Checker.checkDoubleParam( "second", second, outErrors, outAttribute );
        double thirdDouble = Checker.checkDoubleParam( "third", third, outErrors, outAttribute );

        if (outErrors.size() == 0) { // ошибок нету
            outAttribute.put("result", Double.toString( firstDouble * secondDouble * thirdDouble ));
        }
        model.addAttribute("outAttribute", outAttribute);
        model.addAttribute("outErrors", outErrors);

        return new ModelAndView("triangle");
    }


    @RequestMapping(value = "square", method = RequestMethod.GET)
    public ModelAndView shapeSquare(Model model) {
        outErrors.clear();
        outAttribute.clear();
        return new ModelAndView("square");
    }

    @RequestMapping(value = "square", method = RequestMethod.POST)
    public ModelAndView shapeSquare(@RequestParam(value="first", required=true) String first, Model model) {
        outErrors.clear();
        outAttribute.clear();
        double firstDouble = Checker.checkDoubleParam( "first", first, outErrors, outAttribute );
        if (outErrors.size() == 0) { // ошибок нету
            outAttribute.put("result", Double.toString( firstDouble * firstDouble ));
        }
        model.addAttribute("outAttribute", outAttribute);
        model.addAttribute("outErrors", outErrors);

        return new ModelAndView("square");
    }

    @RequestMapping(value = "rectangle", method = RequestMethod.GET)
    public ModelAndView shapeRectangle(Model model) {
        outErrors.clear();
        outAttribute.clear();
        return new ModelAndView("rectangle");
    }

    @RequestMapping(value = "rectangle", method = RequestMethod.POST)
    public ModelAndView shapeRectangle(@RequestParam(value="first", required=true) String first,
                                       @RequestParam(value="second", required=true) String second,
                                       Model model) {
        outErrors.clear();
        outAttribute.clear();
        double firstDouble = Checker.checkDoubleParam( "first", first, outErrors, outAttribute );
        double secondDouble = Checker.checkDoubleParam( "second", second, outErrors, outAttribute );
        if (outErrors.size() == 0) { // ошибок нету
            outAttribute.put("result", Double.toString( firstDouble * secondDouble ));
        }
        model.addAttribute("outAttribute", outAttribute);
        model.addAttribute("outErrors", outErrors);

        return new ModelAndView("rectangle");
    }

    @RequestMapping(value = "circle", method = RequestMethod.GET)
    public ModelAndView shapeCircle(Model model) {
        outErrors.clear();
        outAttribute.clear();
        return new ModelAndView("circle");
    }

    @RequestMapping(value = "circle", method = RequestMethod.POST)
    public ModelAndView shapeCircle(@RequestParam(value="radius", required=true) String radius, Model model) {
        outErrors.clear();
        outAttribute.clear();
        double radiusDouble = Checker.checkDoubleParam( "radius", radius, outErrors, outAttribute );
        if (outErrors.size() == 0) { // ошибок нету
            outAttribute.put("result", Double.toString( Math.PI *  radiusDouble * radiusDouble ));
        }
        model.addAttribute("outAttribute", outAttribute);
        model.addAttribute("outErrors", outErrors);

        return new ModelAndView("circle");
    }




}
