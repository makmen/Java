package by.auto;

import com.sun.org.glassfish.gmbal.NameValue;
import javafx.beans.NamedArg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by AMakas on 22.02.2017.
 */

public class Musician {
    private String song;
    public String getSong() {
        return song;
    }
    public void setSong(String song) {
        this.song = song;
    }

    @Autowired
    @Qualifier("accordion")
    private IInstrument instrument;
    public IInstrument getInstrument() {
        return instrument;
    }


    public void setInstrument(IInstrument instrument) {
        this.instrument = instrument;
    }

    public Musician() {

    }


    public Musician(IInstrument instrument) {
        this.instrument = instrument;
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
