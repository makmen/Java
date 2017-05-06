package structuring.adapter;

/**
 * Created by AMakas on 17.02.2017.
 */
public class Turkey implements ITurkey {
    @Override
    public void gobble() {
        System.out.println("Turkey Gobble");
    }

    @Override
    public void fly() {
        System.out.println("Turkey Fly");
    }
}
