package generating.factorymethod;

/**
 * Created by AMakas on 18.01.2017.
 */
public class Milk implements Product {
    private String name = "milk";

    @Override
    public String toString() {
        return "Milk{" +
                "name='" + name + '\'' +
                '}';
    }
}
