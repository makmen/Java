package library.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by AMakas on 08.02.2017.
 */
public class Genre {
    private final StringProperty title;

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public Genre(String title) {
        this.title = new SimpleStringProperty(title);
    }

    @Override
    public String toString() {
        return title.getValue();
    }
}
