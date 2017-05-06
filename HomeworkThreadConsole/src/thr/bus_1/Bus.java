package thr.bus_1;

import thr.lib.TextLib;

import java.util.UUID;

/**
 * Created by AMakas on 30.01.2017.
 */
public class Bus {
    private String num;

    public UUID getUid() {
        return uid;
    }

    private UUID uid;

    public Bus() {
        uid = UUID.randomUUID();
        num = TextLib.generateNumCar();
    }

    @Override
    public String toString() {
        return "Bus{" +
                "num='" + num + '\'' +
                ", uid=" + uid +
                '}';
    }
}
