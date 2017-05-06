package by.shapes;

import lib.Checker;
import lib.Number;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AMakas on 15.02.2017.
 */
@WebServlet("/triangle")
public class Triangle extends HttpServlet {
    private List<String> outErrors = new ArrayList<>();
    private Map<String, String> outAttribute = new HashMap<>();

    public Triangle() {
        super();
    }

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        outErrors.clear();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        outAttribute.put("first", "0");
        outAttribute.put("second", "0");
        outAttribute.put("third", "0");
        outAttribute.put("result", "0");

        System.out.println(outErrors.size());

        request.setAttribute("outAttribute", outAttribute);
        request.setAttribute("outErrors", outErrors);
        request.getRequestDispatcher("WEB-INF/jsps/triangle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        outErrors.clear();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        double first = Checker.checkDoubleParam( "first", request.getParameter("first"), outErrors, outAttribute );
        double second = Checker.checkDoubleParam( "second", request.getParameter("second"), outErrors, outAttribute );
        double third = Checker.checkDoubleParam( "third", request.getParameter("third"), outErrors, outAttribute );

        outAttribute.put("result", "0");
        if (outErrors.size() == 0) { // ошибок нету
            outAttribute.put("result", Double.toString( areaShape(first, second, third) ));
        }

        request.setAttribute("outAttribute", outAttribute);
        request.setAttribute("outErrors", outErrors);
        request.getRequestDispatcher("WEB-INF/jsps/triangle.jsp").forward(request, response);
    }

    private double areaShape(double a, double b, double c) {
        double p = (a + b + c) / 2;

        return Math.sqrt( p * (p - a) * (p - b) * (p - c));
    }



}
