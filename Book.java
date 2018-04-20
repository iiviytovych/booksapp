package Books.logic;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
 
public class Book implements Comparable
{
    private int BookId;

       private String Author;
  
       private String Name_b;

 
    public Book(ResultSet rs) throws SQLException {
        setBookId(rs.getInt(1));
        setAuthor(rs.getString(2));
  
        setName_b(rs.getString(4));
    
    }
 
    public Book() {
    }
 

 
    public int getBookId() {
        return BookId;
    }
 
    public void setBookId(int BookId) {
        this.BookId = BookId;
    }
 
    public String getAuthor() {
        return Author;
    }
 
    public void setAuthor(String Author) {
        this.Author = Author;
    }
 

 
    public String getName_b() {
        return Name_b;
    }
 
    public void setName_b(String Name_b) {
        this.Name_b = Name_b;
    }
 

 
    public String toString() {
        return Name_b + " " + Author;
    }
 
    public int compareTo(Object obj) {
        return this.toString().compareTo(obj.toString());
    }
}