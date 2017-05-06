package thr.tunnelPhaser;

import java.util.concurrent.Phaser;


/**
 * Created by AMakas on 01.02.2017.
 */
public abstract class Exit {
    protected Phaser phaser;

    protected Train train;
    public Train getTrain() {
        return train;
    }

    public Exit() {
        phaser = new Phaser(1);
    }

    public void registerTrain(Train train) {
        new Thread(new TrainMovingPhaser(phaser, train, this)).start();
        phaser.arriveAndAwaitAdvance();

    }

    public abstract String getNameTunnel();
    public abstract String getNameMovingTunnel();




}
