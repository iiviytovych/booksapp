package students.web;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import students.logic.Book;
import students.logic.ManagementSystem;
 
public class SimpleList extends HttpServlet
{
 
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text / html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<B> Список книг</B>");
        pw.println("<table border = 1>");
        try {
            List l = ManagementSystem.getInstance().getAllBooks();
            for (Iterator it = l.iterator(); it.hasNext();) {
                Book gr = (Book) it.next();
                pw.println("<tr>");
                pw.println("<td>" + gr.getBookId() + "</td>");
                pw.println("<td>" + gr.getAuthor() + "</td>");
                pw.println("<td>" + gr.getName_b() + "</td>");
               
                pw.println("</tr >");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        pw.println("</table>");
    }
}