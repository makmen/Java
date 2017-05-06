package generating.factorymethod;

/**
 * Created by AMakas on 18.01.2017.
 */
public class Coffee implements Product {

    private String name = "coffee";

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                '}';
    }
}
