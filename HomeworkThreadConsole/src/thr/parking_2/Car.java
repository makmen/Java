package thr.parking_2;

import thr.lib.TextLib;

import java.util.UUID;

/**
 * Created by AMakas on 30.01.2017.
 */
public class Car {
    private String num;

    public UUID getUid() {
        return uid;
    }

    private UUID uid;

    public Car() {
        uid = UUID.randomUUID();
        num = TextLib.generateNumCar();
    }

    @Override
    public String toString() {
        return "Car{" +
                "num='" + num + '\'' +
                ", uid=" + uid +
                '}';
    }
}
