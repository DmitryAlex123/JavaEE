import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Servlet_Edit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = SQL_Operation.selectOne(id);
            if(student != null){
                request.setAttribute("student", student); //закидываем объект в поля edit.jsp
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else{
                getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
            }
        }
        catch (Exception e){
            getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }
    //получаем из edit.jsp отредактированные данные
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int grNum = Integer.parseInt(request.getParameter("group_number"));
            Student student = new Student(id, name, grNum);
            SQL_Operation.update(student);
            response.sendRedirect(request.getContextPath() + "/servlet");
        }catch (Exception e){
            getServletContext().getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }
}
