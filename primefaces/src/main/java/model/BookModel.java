package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.BookDAO;
import entity.Book;
 
@ManagedBean
@SessionScoped
public class BookModel implements Serializable{
 
    private static final long serialVersionUID = -3104501356925971373L;
     
    private List<Book> Books;
 
    public BookModel() {
        Books = new ArrayList<Book>();
        reload();
    }
     
    private void reload() {
        this.setBooks(BookDAO.Factory.getInstance().findAll());
    }
 
    /**
     * @return the Books
     */
    public List<Book> getBooks() {
        return this.Books;
    }
 
    /**
     * @param Books the Books to set
     */
    public void setBooks(final List<Book> Books) {
        this.Books = Books;
    }
     
    public void save(Book p) {
        BookDAO.Factory.getInstance().save(p);
        reload();
    }
     
    public Book find(Integer id) {
        return BookDAO.Factory.getInstance().findById(id);
    }
 
    public void delete(Integer bookId) {
        BookDAO.Factory.getInstance().delete(bookId);
        reload();
    }
     
}