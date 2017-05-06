package by.test;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by AMakas on 22.02.2017.
 */
public class Piano implements IInstrument {
    public String play() {
        return this + " Piano";
    }
}
