package generating.singlton;

/**
 * Created by AMakas on 18.01.2017.
 */
public class SingltonFinal {
    private final static SingltonFinal INSTANCE = new SingltonFinal();

    private SingltonFinal() {

    }

    public static SingltonFinal getInstance() {
        return INSTANCE;
    }
}
