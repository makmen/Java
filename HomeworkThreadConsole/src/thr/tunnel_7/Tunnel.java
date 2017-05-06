package thr.tunnel_7;

import java.util.concurrent.Semaphore;

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
        new Thread( new Carrier(this) ).start();
    }

    synchronized void notifyCarrier() {
        notify();
    }

    synchronized void waitCarrier() {
        try {
            wait();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
