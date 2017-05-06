package library.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by AMakas on 08.02.2017.
 */
public class Publishing {
    private final StringProperty title;
    private final StringProperty country;

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public Publishing(String title, String country ) {
        this.title = new SimpleStringProperty(title);
        this.country = new SimpleStringProperty(country);
    }

    @Override
    public String toString() {
        return title.getValue() + ": " + country.getValue();
    }
}
