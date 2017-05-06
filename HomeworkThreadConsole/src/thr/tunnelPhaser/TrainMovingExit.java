package thr.tunnelPhaser;

/**
 * Created by AMakas on 02.02.2017.
 */
public class TrainMovingExit implements Runnable {
    private Train train;

    public TrainMovingExit(Train train) {
        this.train = train;
    }

    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000 + 500));
            System.out.println(train.toString() + " подъезжает к " + train.getExit().getNameTunnel() + " входу в тоннель. ");

            // trying to take phaser
            train.takePhaser();

            Thread.sleep((int) (Math.random() * 500 ));
            System.out.println(train.toString() + " уезжаем прочь!!!"  );

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
