package behaving.state;

/**
 * Created by AMakas on 01.02.2017.
 */
public class ThreadShip implements Runnable {

    private Ship ship;

    public ThreadShip(Ship ship) {
        this.ship = ship;
    }
    // поток отвечает за движение коробля к указанному порту от другого порта
    public void run() {
        try {
            int index = 0;
            while(true) {
                System.out.println(ship.toString() + " уплывает от порта " +
                        ship.getDirectionFrom() +  " к порту " + ship.getDirectionTo() +
                        " для " + ship.getState().typeOfWork()
                );
                Thread.sleep((int) (Math.random() * 1000 + 1000));

                System.out.println(ship.toString() + " приплыли к порту " + ship.getDirectionTo());
                Thread.sleep((int) (Math.random() * 500 ));

                System.out.println(ship.toString() + " выполняем операцию " + ship.getState().typeOfWork());
                ship.getState().work(ship);

                Thread.sleep((int) (Math.random() * 500 ));
                System.out.println(ship.toString() + " выполнено. Готовимся к отплытию. Грузоподъемность порта: " + ship.getDirectionTo().getCurrentConteiners());

                ship.changeState();
                ship.defineDirection();
                if (index++ == 100) break;
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void defineOperation() {

    }

}
