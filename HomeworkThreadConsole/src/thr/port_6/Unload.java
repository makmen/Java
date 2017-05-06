package thr.port_6;

/**
 * Created by AMakas on 01.02.2017.
 */
public class Unload implements IStrategy {

    public boolean work(Ship ship) {
        if (ship.getTotalContainers() == 0) {
            System.out.println(ship.toString() + " че приехал пустым? Вон!!!");
            return true;
        }
        boolean unloaded = ship.getPort().unloading(ship);
        if (unloaded) { // нормально разгружаемся
            System.out.println(ship.toString() + " корабль разгружен. Грузоподъемность порта №" + ship.getPort().getTotalContainers());
        } else {
            System.out.println(ship.toString() + " Нет месту для контейнеров в порту. Ожидайте. Грузоподъемность порта №" + ship.getPort().getTotalContainers());
        }

        return unloaded;
    }
}
