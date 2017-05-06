package behaving.state;

import java.util.UUID;

/**
 * Created by AMakas on 10.02.2017.
 */
public class Ship {
    private UUID id;

    private int capacity;
    public int getCapacity() {
        return capacity;
    }

    private int totalContainers;
    public int getTotalContainers() {
        return totalContainers;
    }
    public void setTotalContainers(int totalContainers) {
        this.totalContainers = totalContainers;
    }

    private int currentState;

    private IStateShip state;
    public IStateShip getState() {
        return state;
    }

    private ThreadShip threadShip;

    private Port directionTo;
    public Port getDirectionTo() {
        return directionTo;
    }

    private Port directionFrom;
    public Port getDirectionFrom() {
        return directionFrom;
    }

    public void defineDirection() {
        Port temp = directionTo;
        directionTo = directionFrom;
        directionFrom = temp;
    }

    public void changeState() {
        if (++currentState > 2) {
            currentState = 0;
        }
        switch(currentState) {
            case 0: // разгрузка корабля
                state = new UnloadShip();
                break;
            case 1:// загрузка корабля
                state = new LoadShip();
                break;
            default: // разгрузка корабля а затем погрузка
                state = new LoadUnloadShip();
        }
    }

    public Ship(Port directionTo, Port directionFrom) {
        id = UUID.randomUUID();
        this.directionTo = directionTo;
        this.directionFrom = directionFrom;
        capacity = (int)(Math.random()*50 + 1);
        totalContainers = 0;
        currentState = 0;
        changeState();

        threadShip = new ThreadShip(this);
        new Thread( threadShip ).start();
    }

    public void work() {
        state.work(this);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", totalContainers=" + totalContainers +
                '}';
    }
}
