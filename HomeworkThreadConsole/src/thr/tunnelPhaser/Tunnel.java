package thr.tunnelPhaser;


/**
 * Created by AMakas on 01.02.2017.
 */
public class Tunnel {
    private ExitLeft exitLeft;
    public ExitLeft getExitLeft() {
        return exitLeft;
    }

    private ExitRight exitRight;
    public ExitRight getExitRight() {
        return exitRight;
    }

    public Tunnel() {
        exitLeft = new ExitLeft();
        exitRight = new ExitRight();

        // поток перевозчик
        //new Thread( new Carrier(this) ).start();
    }



}
