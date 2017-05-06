package by.shapes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AMakas on 16.02.2017.
 */
@WebServlet("/trapeze")
public class Trapeze extends HttpServlet {
    public Trapeze() {
        super();
    }

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        request.getRequestDispatcher("WEB-INF/jsps/triangle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        request.getRequestDispatcher("WEB-INF/jsps/triangle.jsp").forward(request, response);

    }


}
