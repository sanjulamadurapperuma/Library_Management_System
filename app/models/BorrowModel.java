package models;

import io.ebean.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "borrow")
@Embeddable
public class BorrowModel extends Model implements Serializable{

    @EmbeddedId
    @JoinColumn(name = "isbnNumber", referencedColumnName = "isbn")
    private int isbn;

    @EmbeddedId
    @JoinColumn(name = "readerId", referencedColumnName = "id")
    private int readerId;

    @Column(name = "dateTimeBorrowed")
    private String dateTimeBorrowed;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getDateTimeBorrowed() {
        return dateTimeBorrowed;
    }

    public void setDateTimeBorrowed(String dateTimeBorrowed) {
        this.dateTimeBorrowed = dateTimeBorrowed;
    }
}
