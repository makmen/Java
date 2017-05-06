package structuring.adapter;

/**
 * Created by AMakas on 17.02.2017.
 */
public class Duck implements IDuck {

    @Override
    public void quack() {
        System.out.println("Duck Quack");
    }

    @Override
    public void fly() {
        System.out.println("Duck Fly");
    }
}
