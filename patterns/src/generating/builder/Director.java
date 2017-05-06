package generating.builder;

/**
 * Created by AMakas on 20.01.2017.
 */
public class Director {
    public static User createUser(BaseBuilder builder) {
        builder.buildLogin();
        builder.buildPassword();

        return builder.getUser();
    }
}
