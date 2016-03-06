package controller;

import java.io.Serializable;
import java.util.List;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import entity.Book;
import model.BookModel;
 
/**
 */
@ManagedBean
@SessionScoped
public class BookController implements Serializable {
 
	
	private static final long serialVersionUID = -6557818468188090120L;
 
    @ManagedProperty("#{bookModel}")
    private BookModel bookModel;
 
    private final static String EDIT_BOOK = "editBook.xhtml";
    private final static String LIST_BOOKS = "books.xhtml";
     
    private Book currentBook;
    private int bookId;
 
    /**
     * @return the bookModel
     */
    public BookModel getbookModel() {
        return this.bookModel;
    }
 
    /**
     * @param bookModel the bookModel to set
     */
    public void setbookModel(final BookModel bookModel) {
        this.bookModel = bookModel;
    }
 
    public List<Book> getBooks() {
        return this.bookModel.getBooks();
    }
 
    public String create() {
        currentBook = new Book();
        return EDIT_BOOK;
    }
     
    public String edit() {
        currentBook = this.bookModel.find(getBookId());
        return EDIT_BOOK;
    }
 
    public String save() {
        bookModel.save(currentBook);
        return LIST_BOOKS;
    }
     
    public String delete() {
        bookModel.delete(getBookId());
        return LIST_BOOKS;
    }
 
    public Book getCurrentBook() {
        return currentBook;
    }
 
    public void setCurrentBook(Book currentBook) {
        this.currentBook = currentBook;
    }
 
    public int getBookId() {
        return bookId;
    }
 
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
 
}