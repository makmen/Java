package thr.restaurant_4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by AMakas on 31.01.2017.
 */
public class CashBox {
    private int id;
    public int getId() {
        return id;
    }

    public int totalClientsInQueue = 0; // количество человек в очереди
    public int getTotalClientsInQueue() {
        return totalClientsInQueue;
    }

    private ArrayList<Client> clients = new ArrayList<Client>(); // не используем очередь так как клиенты могут мигрировать в другую очередь

    private ReentrantLock locker;
    private Condition condition;

    private Thread handler;

    public CashBox(int id) {
        this.id = id;
        locker = new ReentrantLock();
        condition = locker.newCondition();
        handler = new Thread( new HandlerClients( this ) );
        handler.start();
    }

    public void addClient(Client client) {
        clients.add(client);
        totalClientsInQueue += 1;
        try {
            locker.lock();
            condition.signalAll();
        } finally{
            locker.unlock();
        }
    }

    synchronized public void handlerClients() {
        try {
            if (this.totalClientsInQueue != 0) {
                Client firstClientInQuiue = clients.get(0);

                System.out.println(firstClientInQuiue.toString() + " заказывает у кассы № " + this.id);
                Thread.sleep( (int)( Math.random()*3000 + 500 )); // покупает клиент что-то

                System.out.println(firstClientInQuiue.toString() + " ушел из кассы № " + this.id);
                Thread.sleep( (int)( Math.random()*500 + 500 ));

                clients.remove(0);
                --totalClientsInQueue;

                firstClientInQuiue.notifyClient();
            } else {
                System.out.println("Свободная касса № " + this.id);
                locker.lock();
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            if (locker.isLocked()) {
                locker.unlock();
            }
        }


    }

}
