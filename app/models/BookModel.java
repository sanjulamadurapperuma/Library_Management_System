package models;

import io.ebean.Model;
import services.DateTime;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class BookModel {

    @Id
    @Column(name = "isbn")
    private int isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "sector")
    private String sector;

    @Column(name = "publicationDate")
    private DateTime publicationDate;

    @Column(name = "dateTimeBorrowed")
    private DateTime dateTimeBorrowed;

    @ManyToMany(mappedBy = "books")
    private List<AuthorModel> authors;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "numberOfPages")
    private int numberOfPages;

    @ManyToOne
    @JoinColumn(name = "reader", referencedColumnName = "id")
    private ReaderModel reader;


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public DateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(DateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public DateTime getDateTimeBorrowed() {
        return dateTimeBorrowed;
    }

    public void setDateTimeBorrowed(DateTime dateTimeBorrowed) {
        this.dateTimeBorrowed = dateTimeBorrowed;
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorModel> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public ReaderModel getReader() {
        return reader;
    }

    public void setReader(ReaderModel reader) {
        this.reader = reader;
    }


}
