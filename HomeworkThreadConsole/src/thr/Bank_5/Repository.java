package thr.Bank_5;

/**
 * Created by AMakas on 31.01.2017.
 */
public class Repository {
    private double totalMoney = 800000;

    public double getTotalMoney() {
        return totalMoney;
    }

    synchronized public double getMoney(double limit) {
        return totalMoney - limit;
    }
    synchronized public double addMoney(double limit) {
        return totalMoney + limit;
    }
}
