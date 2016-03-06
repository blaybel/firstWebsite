package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
 
/**
 */
@Entity
public class Book implements Serializable {
 
    /**
     * 
     */
    private static final long serialVersionUID = -3397263129495350023L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_gen")
    @SequenceGenerator(name = "book_seq_gen", sequenceName = "book_seq", allocationSize = 1)
    private Integer id;
 
    @Column
    private String title;
 
    @Column
    private String author;
 
    @Column
    private String publisher;
 
     
 // Getter
    public Integer getId() {
        return this.id;
    }
   
    public String getTitle() {
        return title;
    } 
 
    public String getPublisher() {
        return publisher;
    }
  
    public String getAuthor() {
        return author;
    }

 // Setter
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
}