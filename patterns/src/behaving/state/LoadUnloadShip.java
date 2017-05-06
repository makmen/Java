package behaving.state;

/**
 * Created by AMakas on 10.02.2017.
 */
public class LoadUnloadShip implements IStateShip {
    @Override
    public void work(Ship ship) {
        ship.getDirectionTo().setCurrentConteiners(
            ship.getDirectionTo().getCurrentConteiners() + ship.getTotalContainers()
        );
        ship.setTotalContainers(0);
        int needWeight = (int)(Math.random()*( ship.getCapacity() - ship.getTotalContainers() )); // не полностью загружаем
        ship.getDirectionTo().setCurrentConteiners(
                ship.getDirectionTo().getCurrentConteiners() - needWeight
        );
        ship.setTotalContainers(needWeight);
    }

    @Override
    public String typeOfWork() {
        return " разгрузки-загрузки корабля.";
    }
}
