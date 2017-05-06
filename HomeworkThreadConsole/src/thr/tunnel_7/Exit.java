package thr.tunnel_7;

import java.util.concurrent.Semaphore;

/**
 * Created by AMakas on 01.02.2017.
 */
public abstract class Exit {
    protected Semaphore semaphore;

    protected Train train;
    public Train getTrain() {
        return train;
    }

    public Exit() {
        semaphore = new Semaphore(1, true);
    }

    public abstract String getNameTunnel();
    public abstract String getNameMovingTunnel();

    public void takeSemaphor(Train train) {
        try {
            semaphore.acquire();
            this.train = train;
            System.out.println(train.toString() + " ожидает переезд " + train.getExit().getNameMovingTunnel() + " по тоннелю. ");
            train.getTunnel().notifyCarrier();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void releaseSemaphor() {
        train = null;
        semaphore.release();
    }


}
