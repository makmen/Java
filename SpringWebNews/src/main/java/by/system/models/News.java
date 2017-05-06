package by.system.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by AMakas on 06.03.2017.
 */
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private Date registed;

    @Column(nullable = false)
    private Date updated;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable=false)
    Account account;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getRegisted() {
        return registed;
    }

    public void setRegisted(Date registed) {
        this.registed = registed;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", registed=" + registed +
                ", updated=" + updated +
                ", account=" + account +
                '}';
    }
}
