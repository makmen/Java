package generating.factorymethod;

/**
 * Created by AMakas on 18.01.2017.
 */
public class CreatorMilk extends Creator {
    public Product factoryMethod() {
        return new Milk();
    }
}
