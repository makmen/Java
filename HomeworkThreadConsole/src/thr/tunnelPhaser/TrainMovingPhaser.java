package thr.tunnelPhaser;

import java.util.concurrent.Phaser;

/**
 * Created by AMakas on 02.02.2017.
 */
public class TrainMovingPhaser implements Runnable {
    private Phaser phaser;
    private Train train;
    private Exit exit;

    public TrainMovingPhaser(Phaser phaser, Train train, Exit exit) {
        this.phaser = phaser;
        this.train = train;
        this.exit = exit;
        phaser.register();
    }

    public void run(){
        try {
            System.out.println(" выполняет фазу " + phaser.getPhase());
            System.out.println(train.toString() + " едем с " + exit.getNameMovingTunnel() + " по тонелю ... "  );
            Thread.sleep((int) (Math.random() * 1000 + 1000));

            phaser.arriveAndDeregister();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
