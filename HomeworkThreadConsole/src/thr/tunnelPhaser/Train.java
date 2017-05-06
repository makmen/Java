package thr.tunnelPhaser;

import java.util.UUID;

/**
 * Created by AMakas on 01.02.2017.
 */
public class Train {

    private UUID uid;
    public UUID getUid() {
        return uid;
    }

    private Tunnel tunnel;
    public Tunnel getTunnel() {
        return tunnel;
    }

    private Exit exit;
    public Exit getExit()
    {
        return exit;
    }

    public Train(Tunnel tunnel) {
        this.tunnel = tunnel;
        uid = UUID.randomUUID();
        if ( (int)(Math.random()*2) > 0 ) { // едем к левому входу
            exit = tunnel.getExitLeft();
        } else {// едем к правому входу
            exit = tunnel.getExitRight();
        }
        new Thread( new TrainMovingExit(this) ).start();
    }

    public void takePhaser() {
        exit.registerTrain(this);
    }

    @Override
    public String toString() {
        return "Train{" +
                "uid=" + uid +
                '}';
    }
}
