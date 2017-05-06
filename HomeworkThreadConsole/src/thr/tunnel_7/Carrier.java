package thr.tunnel_7;

/**
 * Created by AMakas on 01.02.2017.
 */
public class Carrier implements Runnable {

    private boolean leftRight = true;
    private Tunnel tunnel;
    private Exit exit;

    public Carrier(Tunnel tunnel) {
        this.tunnel = tunnel;
    }

    private boolean tryMove() {
        boolean ready = false;
        if (exit.getTrain() != null) {
            ready = true;
        }

        return ready;
    }

    public void defineDirection() {
        boolean ready = false;
        while(!ready) {
            for (int i = 0; i < 2; i++) {
                if (leftRight) {
                    exit = tunnel.getExitLeft();
                    leftRight = false;
                } else {
                    exit = tunnel.getExitRight();
                    leftRight = true;
                }
                ready = tryMove();
                if (ready) {
                    break;
                }
            }
            // если нет поездов засыпаем
            if (!ready) {
                System.out.println("Тоннель пуст. ");
                tunnel.waitCarrier();
            }
        }
    }

    public void run() {
        try {
            Train train = null;

            while(true) {
                // определяем направление
                defineDirection();

                // едем ...
                train = exit.getTrain();
                System.out.println(train.toString() + " едем с " + exit.getNameMovingTunnel() + " по тонелю ... "  );
                Thread.sleep((int) (Math.random() * 1000 + 1000));

                System.out.println(train.toString() + " уезжаем прочь!!!"  );
                exit.releaseSemaphor();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
