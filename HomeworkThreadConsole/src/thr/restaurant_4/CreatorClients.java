package thr.restaurant_4;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by AMakas on 31.01.2017.
 */
public class CreatorClients implements Runnable {
    private Client client;

    public CreatorClients(Client client) {
        this.client = client;
    }

    public void run() {

        try {
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println(client.toString() + " пришел в ресторан. Определяет в какую очередь стать. ");

            client.selectBestQueue();

            client.waiting();

            System.out.println(client.toString() + " едим. ");
            Thread.sleep((int) (Math.random() * 1000 + 2000));

            System.out.println(client.toString() + " уходим из ресторана. ");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
