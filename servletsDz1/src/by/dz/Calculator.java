package by.dz;

import lib.*;
import lib.Number;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AMakas on 15.02.2017.
 */
@WebServlet("/calc")
public class Calculator extends HttpServlet {
    private Map<String, String> outAttribute = new HashMap<String, String>();
    private Map<String, String> outErrors = new HashMap<String, String>();

    public Calculator() {
        super();
    }

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        outErrors.clear();

        /*outAttribute.put("first", "0");
        outAttribute.put("second", "0");
        outAttribute.put("result", "0");*/

        outAttribute.put("prt", "0");

        request.setAttribute("outAttribute", outAttribute);
        request.setAttribute("outErrors", outErrors);
        request.getRequestDispatcher("WEB-INF/jsps/all.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        outErrors.clear();

        double first = checkDoubleParam( "first", request.getParameter("first") );
        double second = checkDoubleParam( "second", request.getParameter("second") );

        outAttribute.put("result", "0");
        if (outErrors.size() == 0) { // ошибок нету
            Operation operation = defineOperation( request.getParameter("prt") );
            if ( operation != null ) {
                outAttribute.put("result", Double.toString( operation.calculation(first, second) ));
            }
        }

        request.setAttribute("outAttribute", outAttribute);
        request.setAttribute("outErrors", outErrors);
        request.getRequestDispatcher("WEB-INF/jsps/all.jsp").forward(request, response);
    }

    private Operation defineOperation(String value) {
        StringBuilder error = new StringBuilder("");
        int num = Number.getInt(value, error);
        Operation operation = null;
        if (error.toString().equals("")) {
            operation = new Operation();
            switch (num) {
                case 1:
                    operation.setStrategy(new OperationMultiplication());
                    break;
                case 2:
                    operation.setStrategy(new OperationDivision());
                    break;
                case 3:
                    operation.setStrategy(new OperationAddition());
                    break;
                default:
                    operation.setStrategy(new OperationSubtraction());
            }
            outAttribute.put("prt", Integer.toString(num));
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


    public void destroy() {
        super.destroy();
    }

}
