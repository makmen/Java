package by.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by AMakas on 23.02.2017.
 */
@Component
@Scope("prototype")
public class JagglerSmaty implements IJuggler {
    private int beanBags = 20;
    private int bins = 10;

    public JagglerSmaty() {

    }

    public void perfom() {
        System.out.println("JagglerSmaty: bags=" + beanBags + ", bins=" + bins);
    }

}
