package generating.singlton;

/**
 * Created by AMakas on 18.01.2017.
 */
public class Singlton {
    private static Singlton instance;

    private Singlton() {

    }

    public static Singlton getInstance() {
        if (instance == null){
            instance = new Singlton();
        }

        return instance;
    }
}
