package thr.producer;

/**
 * Created by AMakas on 31.01.2017.
 */
public class Producer implements Runnable {
    private Store store;

    public Producer(Store store){
        this.store=store;
    }

    public void run(){
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
