package by.test;

/**
 * Created by AMakas on 21.02.2017.
 */
public class Juggler implements IJuggler {

    private int beanBags = 3;

    public Juggler() {

    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    public void perfom() {
        System.out.println("Juggler: " + beanBags);
    }
}
