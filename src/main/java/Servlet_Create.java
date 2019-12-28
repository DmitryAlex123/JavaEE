import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet_Create extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int grNum = Integer.parseInt(request.getParameter("group"));
            Student student = new Student(id, name, grNum);
            SQL_Operation.insert(student);
            response.sendRedirect(request.getContextPath() + "/servlet");
        }catch (Exception e){
            getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }
}
