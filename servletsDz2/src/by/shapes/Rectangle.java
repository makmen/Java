package by.shapes;

import lib.Checker;

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
 * Created by AMakas on 16.02.2017.
 */
@WebServlet("/rectangle")
public class Rectangle   extends HttpServlet {
    private List<String> outErrors = new ArrayList<>();
    private Map<String, String> outAttribute = new HashMap<>();
    public Rectangle() {
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
        outAttribute.put("result", "0");

        request.setAttribute("outAttribute", outAttribute);
        request.setAttribute("outErrors", outErrors);
        request.getRequestDispatcher("WEB-INF/jsps/rectangle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        outErrors.clear();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        double first = Checker.checkDoubleParam( "first", request.getParameter("first"), outErrors, outAttribute );
        double second = Checker.checkDoubleParam( "second", request.getParameter("second"), outErrors, outAttribute );

        outAttribute.put("result", "0");
        if (outErrors.size() == 0) { // ошибок нету
            outAttribute.put("result", Double.toString( first * second ));
        }

        request.setAttribute("outAttribute", outAttribute);
        request.setAttribute("outErrors", outErrors);
        request.getRequestDispatcher("WEB-INF/jsps/rectangle.jsp").forward(request, response);

    }


}