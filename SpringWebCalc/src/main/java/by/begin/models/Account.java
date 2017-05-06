package by.begin.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by AMakas on 27.02.2017.
 */
public class Account {
    @NotNull  // won’t allow a null value, which is what Spring MVC generates if the entry is empty
    @Size(min=1, max=5)
    private String fullName;

    //@NotNull
    //@Size(min=1, max=5) // will only allow names between 2 and 5 characters long
    private String login;

    //@Size(min=4)
    private String password;

    @Min(value = 45)  //  won’t allow if the age is less than 18
    private int age;

    @NotNull
    private String email;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
