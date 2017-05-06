package generating.builder;

/**
 * Created by AMakas on 20.01.2017.
 */
public abstract class BaseBuilder {

    protected User user = new User();

    public User getUser() {
        return user;
    }

    public abstract void buildLogin();
    public abstract void buildPassword();
}
