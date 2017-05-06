package thr.callcenter_3;



/**
 * Created by AMakas on 31.01.2017.
 */
public class Operator {
    private int id;
    public int getId() {
        return id;
    }

    private Customer customer = null;
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Operator(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                '}';
    }
}
