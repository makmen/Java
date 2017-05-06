package by.test;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by AMakas on 21.02.2017.
 */
public class Accordion implements IInstrument {
    public String play() {
        return this + " Accordion";
    }
}
