package thr.port_6;

import java.util.UUID;

/**
 * Created by AMakas on 01.02.2017.
 */
public class Ship {
    private UUID uid;
    public UUID getUid() {
        return uid;
    }

    private int capacity;           // грузподъемность корабля
    public int getCapacity() {
        return capacity;
    }

    private int totalContainers;    // количество контейнеров на борту
    public int getTotalContainers() {
        return totalContainers;
    }
    public void setTotalContainers(int totalContainers) {
        this.totalContainers = totalContainers;
    }

    private Port port;
    public Port getPort() {
        return port;
    }

    private ThreadShip threadShip;

    private Operation operation;
    public Operation getOperation() {
        return operation;
    }

    public Ship(Port port) {
        this.port = port;
        uid = UUID.randomUUID();
        capacity = (int)(Math.random()*50 + 1);
        totalContainers = (int)(Math.random()*capacity);

        operation = new Operation(this);
        operation.defineStrategy();

        threadShip = new ThreadShip(this);
        new Thread( threadShip ).start();
    }

    @Override
    public String toString() {
        return "Ship{" +
                "uid=" + uid +
                ", capacity=" + capacity +
                ", totalContainers=" + totalContainers +
                '}';
    }
 }
