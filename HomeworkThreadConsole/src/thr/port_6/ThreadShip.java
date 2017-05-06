package thr.port_6;

/**
 * Created by AMakas on 01.02.2017.
 */
public class ThreadShip implements Runnable {

    private Ship ship;

    public ThreadShip(Ship ship) {
        this.ship = ship;
    }

    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000 + 1000));
            System.out.println(ship.toString() + " подплывает к порту.");

            // паркуемся
            ship.getPort().tryPark(ship);
            Thread.sleep((int) (Math.random() * 500 + 500));

            // выполняем загрузку-погрузку
            boolean done = false;
            while (!done) {
                done = ship.getOperation().work();
                if (!done) {
                    Thread.sleep((int) (Math.random() * 3000 + 1000)); // ждем пока в порту освободится место
                }
            }

            // готовимся к отходу
            Thread.sleep((int) (Math.random() * 3000 + 2000));

            // уезжаем
            ship.getPort().goAway(ship);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void defineOperation() {

    }

}
