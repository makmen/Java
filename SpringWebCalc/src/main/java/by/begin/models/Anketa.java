package by.begin.models;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

/**
 * Created by AMakas on 28.02.2017.
 */
@Entity
@Table(name = "anketa")
public class Anketa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String surname;

    @Column(nullable=false)
    private String lastname;

    @Column(nullable=false)
    private String email;

    @Column
    private String phone;

    @Column(nullable=false)
    private int age = 20;

    @Column(nullable=false)
    private String country = "Россия";

    @Column(nullable=false, length = 100)
    private String login;

    @Column(nullable=false, length = 20)
    private String password;

    @Transient
    private String repassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    @Override
    public String toString() {
        return "Anketa{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                '}';
    }
}
