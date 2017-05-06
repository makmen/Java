package generating.factorymethod;

/**
 * Created by AMakas on 18.01.2017.
 */
public class Tea implements Product {
    private String name = "tea";

    @Override
    public String toString() {
        return "Tea{" +
                "name='" + name + '\'' +
                '}';
    }
}
