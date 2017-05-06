package structuring.adapter;

/**
 * Created by AMakas on 17.02.2017.
 */
public class TurkeyAdapter implements IDuck {
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
