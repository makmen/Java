package thr.Bank_5;

import java.util.concurrent.Semaphore;

/**
 * Created by AMakas on 31.01.2017.
 */
public class HandlerClients implements Runnable {
    private CashBox cashBox;

    public HandlerClients(CashBox cashBox) {
        this.cashBox = cashBox;
    }

    public void run() {
        while(true) {
            cashBox.handlerClients();
        }
    }

}

