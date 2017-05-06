package thr.Bank_5;

import thr.restaurant_4.CreatorClients;

import java.util.UUID;

/**
 * Created by AMakas on 31.01.2017.
 */
public class Client {
    private UUID uid;
    public UUID getUid() {
        return uid;
    }

    private Bank bank;
    public Bank getBank() {
        return bank;
    }

    private Creator creator;

    public Client(Bank bank) {
        this.bank = bank;
        uid = UUID.randomUUID();
        creator = new Creator(this);
        new Thread( creator ).start();
    }

    @Override
    public String toString() {
        return "Client{" +
                "uid=" + uid +
                '}';
    }
}
