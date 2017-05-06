package thr.bus_1;

import java.util.ArrayDeque;

/**
 * Created by AMakas on 30.01.2017.
 */
public class BusStop {

    public ArrayDeque<Bus> getBuses() {
        return buses;
    }

    private ArrayDeque<Bus> buses = new ArrayDeque<Bus>();

    public BusStop() {

    }

}
