package Books.web.forms;

import java.text.SimpleDateFormat;
import java.util.Collection;
import Books.logic.Book;

public class BookForm
{
   

       private int BookId;
  
       private String Author;

       private String Name_b;

    public void initFromBook(Book st) {
        this.BookId = st.getBookId();
        this.Author = st.getAuthor();
        this.Name_b = st.getName_b();
       
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

  
}