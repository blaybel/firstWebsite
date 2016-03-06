package DAO;

import java.util.List;

import entity.Book;

public class BookDAO extends BaseDAO {
 
    private BookDAO() {
    }
 
    public boolean delete(Integer id) {
        return delete(id, Book.class);
    }
 
    public Book findById(Integer id) {
        return (Book) findById(id, Book.class);
    }
 
    public List<Book> findAll() {
        return findAll("FROM Book");
    }
 
    public static class Factory {
 
        private final static BookDAO INSTANCE = new BookDAO();
 
        public static BookDAO getInstance() {
            return INSTANCE;
        }
    }
 
}