package by.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by AMakas on 21.02.2017.
 */
@Component
@Scope("prototype")
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
