package thr.restaurant_4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by AMakas on 31.01.2017.
 */
public class HandlerClients implements Runnable {
    private CashBox cashBox;
    public CashBox getCashBox() {
        return cashBox;
    }

    public HandlerClients(CashBox cashBox) {
        this.cashBox = cashBox;
    }

    public void run() {
        while(true) {
            cashBox.handlerClients();
        }
    }

}
