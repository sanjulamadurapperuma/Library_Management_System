package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name = "borrowitem")
public class BorrowModel extends Model{

    @Id
    @Column(name = "isbnNumber")
    private int isbn;

    @Column(name = "readerId")
    private int readerId;

    @Column(name = "dateTimeBorrowed")
    private String dateTimeBorrowed;

    public static Finder<Integer, BorrowModel>
            find = new Finder<>(BorrowModel.class);

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
