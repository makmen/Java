package thr.port_6;

/**
 * Created by AMakas on 01.02.2017.
 */
public class Operation {

    private IStrategy strategy = null;
    protected Ship ship;

    public Operation(Ship ship) {
        this.ship = ship;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void defineStrategy() {
        int rand = (int)(Math.random()*3);
        switch(rand) {
            case 0: // разгрузка корабля
                setStrategy(new Unload());
                break;
            case 1:// загрузка корабля
                setStrategy(new Load());
                break;
            default: // разгрузка корабля а затем погрузка
                setStrategy(new LoadUnload());
        }
    }

    public boolean work() {
        return strategy.work(ship);
    }
}
