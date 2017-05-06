package library.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Entity;
import javax.persistence.*;


/**
 * Created by AMakas on 08.02.2017.
 */
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable=false)
    Genre genre;

    @ManyToOne
    @JoinColumn(name = "publishing_id", nullable=false)
    Publishing publishing;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publishing getPublishing() {
        return publishing;
    }

    public void setPublishing(Publishing publishing) {
        this.publishing = publishing;
    }

    public Book() {

    }

    public Book(String title, String author, Genre genre, Publishing publishing) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishing = publishing;
    }
}
