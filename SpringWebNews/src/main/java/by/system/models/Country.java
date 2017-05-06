package by.system.models;

import javax.persistence.*;

/**
 * Created by AMakas on 07.03.2017.
 */
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String title_full;

    @Column(nullable = false, length = 3)
    private String abbr;

    @Column(nullable = false, length = 2)
    private String code;

    @Column(nullable = false, length = 3)
    private String kod;

    @Column(nullable = false)
    private int priority;

    @Column(nullable = false)
    private int visible;

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

    public String getTitle_full() {
        return title_full;
    }

    public void setTitle_full(String title_full) {
        this.title_full = title_full;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", title_full='" + title_full + '\'' +
                ", abbr='" + abbr + '\'' +
                ", code='" + code + '\'' +
                ", kod='" + kod + '\'' +
                ", priority=" + priority +
                ", visible=" + visible +
                '}';
    }
}

