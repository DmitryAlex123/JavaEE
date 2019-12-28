import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ArrayList<Student> studentsArray = SQL_Operation.select();
        request.setAttribute("studentsArray", studentsArray);
        getServletContext().getRequestDispatcher("/main_page.jsp").forward(request, response);
    }
}
