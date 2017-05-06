package behaving.state;

/**
 * Created by AMakas on 10.02.2017.
 */
public class UnloadShip implements IStateShip {
    @Override
    public void work(Ship ship) {
        ship.getDirectionTo().setCurrentConteiners(
                ship.getDirectionTo().getCurrentConteiners() + ship.getTotalContainers()
        );
        ship.setTotalContainers(0);
    }
    @Override
    public String typeOfWork() {
        return " разгрузки корабля.";
    }
}
