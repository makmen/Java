package thr.callcenter_3;

import java.util.UUID;

/**
 * Created by AMakas on 31.01.2017.
 */
public class Customer {
    private UUID uid;

    public UUID getUid() {
        return uid;
    }

    public Customer() {
        uid = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "uid=" + uid +
                '}';
    }
}
