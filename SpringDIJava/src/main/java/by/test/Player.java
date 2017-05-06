package by.test;

/**
 * Created by AMakas on 22.02.2017.
 */
public class Player {
    private String song;
    public String getSong() {
        return song;
    }
    public void setSong(String song) {
        this.song = song;
    }

    private IInstrument instrument;
    public IInstrument getInstrument() {
        return instrument;
    }
    public void setInstrument(IInstrument instrument) {
        this.instrument = instrument;
    }
    public Player() {

    }
    public Player(IInstrument instrument) {
        this.instrument = instrument;
    }

    public void perfom() {
        System.out.println("playing " + song);
        instrument.play();
    }
}
