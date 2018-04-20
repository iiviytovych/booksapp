package Books.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Books.logic.Group;
import Books.logic.ManagementSystem;
import Books.logic.Book;

import Books.web.forms.MainFrameForm;

public class BookFrameServlet extends HttpServlet
{


    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
      
        req.setCharacterEncoding("UTF-8");
        String sId = req.getParameter("BookId");
     
        if (sId != null && req.getParameter("OK") != null) {
            try {
           
                if (Integer.parseInt(sId) > 0) {
                    updateBook(req);
                } 
                else {
                    insertBook(req);
                }
            } catch (SQLException sql_e) {
                sql_e.printStackTrace();
                throw new IOException(sql_e.getMessage());
            } catch (ParseException p_e) {
                throw new IOException(p_e.getMessage());
            }
        }
       
       }
        MainFrameForm form = new MainFrameForm();
        try {
            Collection Books = ManagementSystem.getInstance().getGroups();
            Book b = new Book();
            g.setGroupId(BookId);
            if (BookId == -1) {
                Iterator i = books.iterator();
                b = (Book) i.next();
            }
            Collection Books = ManagementSystem.getInstance().getBooks(g);
            form.setGroupId(g.getGroupId());
            
            form.setBooks(Books);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        req.setAttribute("form", form);
        getServletContext().getRequestDispatcher("/MainFrame.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void updateBook(HttpServletRequest req) throws SQLException, ParseException {
        Book s = prepareBook(req);
        ManagementSystem.getInstance().updateBook(s);
    }

    private void insertBook(HttpServletRequest req) throws SQLException, ParseException {
        Book s = prepareBook(req);
        ManagementSystem.getInstance().insertBook(s);
    }

    private Book prepareBook(HttpServletRequest req) throws ParseException {
        Book s = new Book();
        s.setBookId(Integer.parseInt(req.getParameter("BookId")));
        s.setFirstName(req.getParameter("firstName").trim());
        s.setName_b(req.getParameter("Name_b").trim());
            return s;
    }
}