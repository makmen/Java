package by.compon;

/**
 * Created by AMakas on 21.02.2017.
 */
public class InstrumentalList {
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
    public InstrumentalList() {

    }
    public InstrumentalList(IInstrument instrument) {
        this.instrument = instrument;
    }

    public void perfom() {
        System.out.println("playing " + song);
        instrument.play();
    }

}
