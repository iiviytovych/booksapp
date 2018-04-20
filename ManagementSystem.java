package Books.logic;
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 
public class ManagementSystem
{
    private static Connection con;
    private static ManagementSystem instance;
    private static DataSource dataSource;
 
    private ManagementSystem() {
    }
 
    public static synchronized ManagementSystem getInstance() {
        if (instance == null) {
            try {
                instance = new ManagementSystem();
                Context ctx = new InitialContext();
                instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/BooksDS");
                con = dataSource.getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
 

 
    public Collection getAllBooks() throws SQLException {
        Collection Books = new ArrayList();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT Book_id, Author, Name_b ORDER BY Name_b, Author");
        while (rs.next()) {
            Book st = new Book(rs);
            Books.add(st);
        }
        rs.close();
        stmt.close();
        return Books;
    }

 
    public Book getBookById(int BookId) throws SQLException {
        Book Book = null;
        PreparedStatement stmt = con.prepareStatement("SELECT Book_id, Author, Name_b FROM Books WHERE Book_id = ?");
        stmt.setInt(1, BookId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Book = new Book(rs);
        }
        rs.close();
        stmt.close();
        return Book;
    }

 
    public void removeBooks(Book Book) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM Books WHERE Book_id = ?");
        stmt.setInt(1, group.getBookId());
        
        stmt.execute();
    }
 
    public void insertBook(Book Book) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO Books "
                + "(Author, Name_b)"
                + "VALUES( ?, ?)");
        stmt.setString(1, Book.getAuthor());
     
        stmt.setString(2, Book.getName_b());
     
        stmt.execute();
    }
 
    public void updateBook(Book Book) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE Books "
                + "SET Author=?,  Name_b=? WHERE Book_id=?");
        stmt.setString(1, Book.getAuthor());
    
        stmt.setString(2, Book.getName_b());
      
        stmt.setInt(3, Book.getBookId());
        stmt.execute();
    }
 
    public void deleteBook(Book Book) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM Books WHERE Book_id =  ?");
        stmt.setInt(1, Book.getBookId());
        stmt.execute();
    }
}