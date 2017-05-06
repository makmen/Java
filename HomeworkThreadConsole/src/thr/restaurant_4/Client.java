package thr.restaurant_4;

import java.util.UUID;

/**
 * Created by AMakas on 31.01.2017.
 */
public class Client {
    private UUID uid;
    public UUID getUid() {
        return uid;
    }

    private boolean ordered = false;
    private CreatorClients creator;

    private Restaurant restaurant;
    public Restaurant getRestaurant() {
        return restaurant;
    }

    private CashBox cashBox = null;
    public CashBox getCashBox() {
        return cashBox;
    }
    public void setCashBox(CashBox cashBox) {
        this.cashBox = cashBox;
    }

    public Client(Restaurant restaurant) {
        this.restaurant = restaurant;
        uid = UUID.randomUUID();
        creator = new CreatorClients(this);
        new Thread( creator ).start();
    }

    public void selectBestQueue() {
        cashBox = restaurant.selectBestQueue(this);
    }


    public synchronized void waiting() {
        try {
            while(!ordered) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void notifyClient() {
        ordered = true;
        notify();
    }

    @Override
    public String toString() {
        return "Client{" +
                "uid=" + uid +
                '}';
    }
}
