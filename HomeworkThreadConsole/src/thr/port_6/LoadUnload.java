package thr.port_6;

/**
 * Created by AMakas on 01.02.2017.
 */
public class LoadUnload implements IStrategy {
    public boolean work(Ship ship) {
        boolean done = true;
        System.out.println(ship.toString() + " погрузка-разгрузка корабля. ");

        if (ship.getTotalContainers() != 0) {
            done = ship.getPort().unloading(ship);
            if (done) { // нормально разгружаемся
                System.out.println(ship.toString() + " корабль разгружен (погрузка-загрузка). Грузоподъемность порта №" + ship.getPort().getTotalContainers());
            } else {
                System.out.println(ship.toString() + " Нет месту для контейнеров в порту. Ожидайте. Грузоподъемность порта №" + ship.getPort().getTotalContainers());
            }
        }
        if (!done) {
            return done;
        }

        done = ship.getPort().loading(ship);
        if (done) { // нормально загружаемся
            System.out.println(ship.toString() + " корабль загружен (погрузка-загрузка). Грузоподъемность порта №" + ship.getPort().getTotalContainers());
        } else {
            System.out.println(ship.toString() + " Нет свободных контейнеров в порту. Ожидайте. Грузоподъемность порта №" + ship.getPort().getTotalContainers());
        }

        return done;
    }
}
