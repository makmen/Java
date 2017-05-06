package library.models;


import javax.persistence.*;

/**
 * Created by AMakas on 08.02.2017.
 */
@Entity
@Table(name = "publishings")
public class Publishing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "country")
    private String country;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Publishing() {

    }

    @Override
    public String toString() {
        return title + ": " + country;
    }
}
