package thr.callcenter_3;

import java.util.ArrayList;

/**
 * Created by AMakas on 31.01.2017.
 */
public class CallCenter {
    private String name = "Call Center";
    private ArrayList<Operator> operators = new ArrayList<Operator>();
    private int limit = 10;

    public CallCenter() {
        for (int i = 0; i < limit; i++) {
            operators.add(new Operator(i + 1));
        }
    }

    public synchronized void endCall(Customer customer) {
        for (Operator operator : operators) {
            if (operator.getCustomer() != null &&
                operator.getCustomer().getUid().equals(customer.getUid())) {
                operator.setCustomer(null);
                System.out.println(customer.toString() + " завершил разговор с оператором: " + operator.getId() );
                System.out.println("Оператор: " + operator.getId() + " свободен " );
                notify();
                break;
            }
        }
    }

    public synchronized void call(Customer customer) {
        boolean success = false;
        while (!success) {
            for (Operator operator : operators) {
                if (operator.getCustomer() == null) {
                    operator.setCustomer(customer);
                    System.out.println(customer.toString() + " дозванился, разговаривает с оператором: " + operator.getId() );
                    success = true;
                    break;
                }
            }
            if (!success) {
                try {
                    System.out.println(customer.toString() + " ожидает подключения оператора ... ");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
