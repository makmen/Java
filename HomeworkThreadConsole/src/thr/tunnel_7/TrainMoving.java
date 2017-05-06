package thr.tunnel_7;

/**
 * Created by AMakas on 01.02.2017.
 */
public class TrainMoving implements Runnable {
    private Train train;

    public TrainMoving(Train train) {
        this.train = train;
    }

    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000 + 500));
            System.out.println(train.toString() + " подъезжает к " + train.getExit().getNameTunnel() + " входу в тоннель. ");

            // встаем в очередь к семофору в тонеле
            train.takeSemaphor();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
