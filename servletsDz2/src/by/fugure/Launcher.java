package by.fugure;

import lib.Number;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AMakas on 15.02.2017.
 */
@WebServlet("/")
public class Launcher  extends HttpServlet {

    public Launcher() {
        super();
    }

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        request.getRequestDispatcher("WEB-INF/jsps/shapes.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder error = new StringBuilder("");
        int num = Number.getInt(request.getParameter("shape"), error);

        if (error.toString().equals("")) {
            switch (num) {
                case 1: // круг
                    request.getRequestDispatcher("/circle").forward(request,response);
                    break;
                case 2: // прямоугольник
                    //response.sendRedirect("rectangle");
                    request.getRequestDispatcher("rectangle").forward(request,response);
                    break;
                case 3: // квадрат
                    break;
                default: // треугольник
                    //response.sendRedirect("/triangle");
                    request.getRequestDispatcher("/triangle").forward(request,response);
            }
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        request.getRequestDispatcher("WEB-INF/jsps/shapes.jsp").forward(request, response);
    }

}
