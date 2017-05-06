package behaving.state;

/**
 * Created by AMakas on 10.02.2017.
 */
public class LoadShip implements IStateShip {
    @Override
    public void work(Ship ship) {
        int needWeight = ship.getCapacity() - ship.getTotalContainers();
        ship.getDirectionTo().setCurrentConteiners(
            ship.getDirectionTo().getCurrentConteiners() - needWeight
        );
        ship.setTotalContainers(needWeight);
    }

    @Override
    public String typeOfWork() {
        return " загрузки корабля.";
    }
}
