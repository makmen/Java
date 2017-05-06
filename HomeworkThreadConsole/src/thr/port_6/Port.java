package thr.port_6;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by AMakas on 01.02.2017.
 */
public class Port {
    private Object limitContainersLocked = new Object();

    private int limitContainers = 3000;

    private int totalContainers = 1500;
    public int getTotalContainers() {
        return totalContainers;
    }

    private int limitShips = 10; // максимальное число припаркованных кораблей
    private Ship[] docs;

    private Semaphore semaphore;

    public Port() {
        semaphore = new Semaphore(limitShips, true);
        docs = new Ship[limitShips];
    }

    public void tryPark(Ship ship) {
        int position = 0;
        try {
            semaphore.acquire();
            for (int i = 0, count = docs.length; i < limitShips; i++) {
                if (docs[i] == null) {
                    docs[i] = ship;
                    position = i + 1;
                    break;
                }
            }
            System.out.println(ship.toString() + " припарковался у причала №" + position);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goAway(Ship ship) {
        int position = 0;
        for (int i = 0, count = docs.length; i < limitShips; i++) {
            if ( docs[i] != null && docs[i].getUid() == ship.getUid() ) {
                docs[i] = null;
                position = i + 1;
                break;
            }
        }
        System.out.println(ship.toString() + " уезжаем из порта. Освобождает причал №" + position);
        semaphore.release(1);
    }

    public boolean unloading(Ship ship) {
        boolean unloaded = false;
        synchronized (limitContainersLocked) {
            int summa = totalContainers + ship.getTotalContainers();
            if (limitContainers >= summa) {
                totalContainers = summa;
                ship.setTotalContainers(0);
                unloaded = true;
            }
        }

        return unloaded;
    }

    public boolean loading(Ship ship) {
        boolean loaded = false;
        int need = ship.getCapacity() - ship.getTotalContainers();
        synchronized (limitContainersLocked) {
            int summa = totalContainers - need;
            if ( summa >= 0 ) {
                totalContainers -= need;
                ship.setTotalContainers(ship.getCapacity());
                loaded = true;
            }
        }

        return loaded;
    }

}
