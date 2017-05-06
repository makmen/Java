package by.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by AMakas on 23.02.2017.
 */
public class JugglerMusician implements IJuggler {
    private int beanBags = 3;

    @Autowired
    private IInstrument instrument;

    public void setInstrument(IInstrument instrument) {
        this.instrument = instrument;
    }

    public JugglerMusician() {

    }

    public void perfom() {
        System.out.println("JugglerMusician: bags=" + beanBags + ", instrument: " + instrument.play());
    }


}
