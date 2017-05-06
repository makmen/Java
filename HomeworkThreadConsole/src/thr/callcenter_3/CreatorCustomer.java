package thr.callcenter_3;

/**
 * Created by AMakas on 31.01.2017.
 */
public class CreatorCustomer implements Runnable {
    private CallCenter callCenter;

    public CreatorCustomer(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    public void run() {
        try {
            Thread.sleep( (int)( Math.random()*500 + 100 )); // задержка
            Customer customer = new Customer();
            System.out.println(customer.toString() + " пытается дозваниться");

            callCenter.call(customer); // пытаемся дозваниться

            Thread.sleep( (int)( Math.random()*1000 + 500 )); // дозванились говорим с оператором

            callCenter.endCall(customer); // завершаем разговор

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
