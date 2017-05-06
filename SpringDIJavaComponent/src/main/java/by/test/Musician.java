package by.test;

import javafx.beans.DefaultProperty;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by AMakas on 22.02.2017.
 */
@Component
public class Musician {

    @Autowired
    @Value("kiki")
    private String song;

    @Autowired
    @Qualifier("piano")
    private IInstrument instrument;

    public Musician() {

    }

    public void perfom() {
        System.out.println("playing " + song);
        if (instrument != null) {
            instrument.play();
        } else {
            System.out.println(instrument);
        }
    }

}
