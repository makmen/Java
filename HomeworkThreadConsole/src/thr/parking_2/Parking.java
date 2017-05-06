package thr.parking_2;

import java.util.ArrayList;

/**
 * Created by AMakas on 30.01.2017.
 */
public class Parking {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int limit = 10;

    public ArrayList<Car> getCars() {
        return cars;
    }

    synchronized Boolean parkCar(Car car) {
        Boolean parked = false;
        if (cars.size() <= limit) {
            cars.add(car);
            parked = true;
        }

        return parked;
    }

    synchronized void leavePark(Car car) {
        for(Car item : cars ) {
            if (item.getUid().equals(car.getUid())) {
                cars.remove(item);
                break;
            }
        }
    }


}
