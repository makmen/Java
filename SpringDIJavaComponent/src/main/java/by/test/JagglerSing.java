package by.test;

import org.springframework.stereotype.Component;

/**
 * Created by AMakas on 23.02.2017.
 */

public class JagglerSing implements IJuggler {

    private String song;

    public JagglerSing(String song) {
        this.song = song;
    }

    public void perfom() {
        System.out.println("JagglerSing: singing song= " + song);
    }


}
