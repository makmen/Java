package thr.port_6;

/**
 * Created by AMakas on 01.02.2017.
 */
public class Load implements IStrategy {

    public boolean work(Ship ship) {
        if (ship.getTotalContainers() == ship.getCapacity()) {
            System.out.println(ship.toString() + " че приехал забытым под завязку? Вон!!!");
            return true;
        }
        boolean loaded = ship.getPort().loading(ship);
        if (loaded) { // нормально загружаемся
            System.out.println(ship.toString() + " корабль загружен. Грузоподъемность порта №" + ship.getPort().getTotalContainers());
        } else {
            System.out.println(ship.toString() + " Нет свободных контейнеров в порту. Ожидайте. Грузоподъемность порта №" + ship.getPort().getTotalContainers());
        }

        return loaded;
    }
}
