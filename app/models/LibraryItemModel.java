package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "libraryitems")
public class LibraryItemModel extends Model {

    /*Start of LibraryItem attributes*/
    @Id
    @Column(name = "isbn")
    private int isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "sector")
    private String sector;

    @Column(name = "publicationDate")
    private Date publicationDate;

    /*End of LibraryItem attributes*/

    /*Start of Book attributes*/

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "numberOfPages")
    private int numberOfPages;

    /*End of Book attributes*/

    /*Start of DVD attributes*/

    @Column(name = "languages")
    private String languages;

    @Column(name = "subtitles")
    private String subtitles;

    @Column(name = "producer")
    private String producer;

    @Column(name = "actors")
    private String actors;

    /*End of DVD attributes*/

    //LibraryItem type check
    @Column(name = "type")
    private String itemType;

    //Borrowed or Available check
    @Column(name = "borrowedStatus")
    private String borrowedStatus;

    //Number of times the item has
    // been borrowed
    @Column(name = "noOfTimesBorrowed")
    private int noOfTimesBorrowed;

    //The average number of hours the
    // item has been borrowed for
    @Column(name = "avgTimeBorrowed")
    private double avgTimeBorrowed;

    //This is the Ebean Finder - Pass the bean type to the finder and it returns the relevant data
    public static Finder<Integer, LibraryItemModel> find = new Finder<>(LibraryItemModel.class);

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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getBorrowedStatus() {
        return borrowedStatus;
    }

    public void setBorrowedStatus(String borrowedStatus) {
        this.borrowedStatus = borrowedStatus;
    }

    public int getNoOfTimesBorrowed() {
        return noOfTimesBorrowed;
    }

    public void setNoOfTimesBorrowed(int noOfTimesBorrowed) {
        this.noOfTimesBorrowed = noOfTimesBorrowed;
    }

    public double getAvgTimeBorrowed() {
        return avgTimeBorrowed;
    }

    public void setAvgTimeBorrowed(double avgTimeBorrowed) {
        this.avgTimeBorrowed = avgTimeBorrowed;
    }
}
