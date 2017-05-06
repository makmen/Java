package thr.restaurant_4;

import java.util.ArrayList;

/**
 * Created by AMakas on 31.01.2017.
 */
public class Restaurant {
    private String name = "Call Center";
    private ArrayList<CashBox> cashBoxes = new ArrayList<CashBox>();

    public ArrayList<CashBox> getCashBoxes() {
        return cashBoxes;
    }

    private int totalCashBoxes = 10;

    public Restaurant() {
        for (int i = 0; i < totalCashBoxes; i++) {
            cashBoxes.add(new CashBox(i + 1));
        }
    }

     public synchronized CashBox selectBestQueue(Client client) {
        CashBox cashBoxBest = null;
        cashBoxBest = cashBoxes.get(0);
        for (CashBox box : cashBoxes) {
            if (cashBoxBest.getTotalClientsInQueue() > box.getTotalClientsInQueue()) {
                cashBoxBest = box;
            }
        }
        System.out.println(client.toString() + " встал в очередь в кассу № " +
                cashBoxBest.getId() + " , " + cashBoxBest.getTotalClientsInQueue());
        cashBoxBest.addClient(client);


        return cashBoxBest;
    }



}
