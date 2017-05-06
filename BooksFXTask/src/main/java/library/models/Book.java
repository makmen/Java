package library.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.UUID;

/**
 * Created by AMakas on 08.02.2017.
 */
public class Book {
    private final StringProperty id;
    private final StringProperty title;
    private final StringProperty author;
    private final StringProperty genre;
    private final StringProperty publishing;

    public Book(String title, String author, String genre, String publishing) {
        this.id = new SimpleStringProperty(UUID.randomUUID().toString());
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.genre = new SimpleStringProperty(genre);
        this.publishing = new SimpleStringProperty(publishing);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public String getPublishing() {
        return publishing.get();
    }

    public StringProperty publishingProperty() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing.set(publishing);
    }
}
