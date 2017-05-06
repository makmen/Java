package org.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AMakas on 08.02.2017.
 */
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "login")
    String login;

    @Column(name = "password")
    String password;

    @Column(name = "name", nullable=false)
    String name;

    @Column(name = "middlename", nullable=false)
    String middlename;

    @Column(name = "lastname", nullable=false)
    String lastname;

    @Column(name = "email", nullable=false)
    String email;

    @Column(name = "phone")
    String phone;

    @ManyToMany(
        fetch = FetchType.LAZY,
        mappedBy = "accounts"
    )
    private Set<Book> books = new HashSet<Book>();

    @ManyToOne
    @JoinColumn(name = "group_id", nullable=false)
    Group group;

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", group=" + group.getTitle() +
                '}';
    }
}
