package models;

import io.ebean.Model;
import services.DateTime;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "dvds")
public class DVDModel extends Model {

    @Id
    @Column(name = "isbn")
    private int isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "sector")
    private String sector;

    @Column(name = "publicationDate")
    private Date publicationDate;

    @Column(name = "languages")
    private String languages;

    @Column(name = "subtitles")
    private String subtitles;

    @Column(name = "producer")
    private String producer;

    @Column(name = "actors")
    private String actors;

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
}
