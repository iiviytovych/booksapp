package Books.web;
 
import java.io.IOException;
import java.sql.SQLException;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import Books.logic.ManagementSystem;
import Books.logic.Book;
 
import Books.web.forms.MainFrameForm;
import Books.web.forms.BookForm;+
 
public class MainFrameServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
   
        req.setCharacterEncoding("UTF-8");
        int answer = 0;
        try {
            answer = checkAction(req);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        if (answer == 1) {
       
            try {
                Book s = new Book();
                s.setBookId(0);
             
                Collection books = ManagementSystem.getInstance().getAllBook();
                BookForm sForm = new BookForm();
                sForm.initFromBook(s);
      
                req.setAttribute("Book", sForm);
                getServletContext().getRequestDispatcher("/BookFrame.jsp").forward(req, resp);
                return;
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            }
 
        }
 
        if (answer == 2) {
       
            try {
                if (req.getParameter("BookId") != null) {
                    int stId = Integer.parseInt(req.getParameter("BookId"));
                    Book s = ManagementSystem.getInstance().getBookById(stId);
             
                    BookForm sForm = new BookForm();
                    sForm.initFromBook(s);
               
                    req.setAttribute("Book", sForm);
                    getServletContext().getRequestDispatcher("/BookFrame.jsp").forward(req, resp);
                    return;
                }
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            }
        }
     
        MainFrameForm form = new MainFrameForm();
        try {
           
            Collection Books = ManagementSystem.getInstance().getBooks(g, year);
          
            Book b = new Book();
             form.setBookId(b.getBookId());
          form.setAuthor(b.getAuthor());
          form.setName_b(b.getName_b());
            form.setBooks(Books);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
 
        req.setAttribute("form", form);
        getServletContext().getRequestDispatcher("/MainFrame.jsp").forward(req, resp);
    }
 

    private int checkAction(HttpServletRequest req) throws SQLException {
        if (req.getParameter("Add") != null) {
            return 1;
        }
        if (req.getParameter("Edit") != null) {
            return 2;
        }
   
        if (req.getParameter("Delete") != null) {
            if (req.getParameter("BookId") != null) {
                Book s = new Book();
                s.setBookId(Integer.parseInt(req.getParameter("BookId")));
                ManagementSystem.getInstance().deleteBook(s);
            }
            return 0;
        }
        return 0;
    }
 

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
 
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
 
}