package thr.Bank_5;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

/**
 * Created by AMakas on 31.01.2017.
 */
public class Observer implements Runnable {
    private CashBox cashBox;

    public Observer(CashBox cashBox) {
        this.cashBox = cashBox;
    }

    public void run() {
        try {
            while(true) {
                Thread.sleep(1000);
                cashBox.observerTime();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
