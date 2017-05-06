package thr.bus_1;

/**
 * Created by AMakas on 30.01.2017.
 */
public class CreatorBus implements Runnable {
    private BusStop busStop;

    public CreatorBus(BusStop busStop) {
        this.busStop = busStop;
    }

    public void run() { // поток создает автобус и пытается подъекхать к остановке
        try {
            Thread.sleep( (int)( Math.random()*1000 )); // задержка чтобы не сразу генерил автобус
            Bus bus = new Bus();
            System.out.println(bus.toString() + " подъезжает к остановке.");

            synchronized ( busStop.getBuses() ) {  // блокируем очередь
                System.out.println(bus.toString() + " останавливается.");
                busStop.getBuses().addLast(bus);
            }
            Thread.sleep( (int)( Math.random()*500 + 100 )); // задержка остановки

            // ждать пока все не уедут с начало очереди.
            Bus busLeaving = null;
            while (true) {
                synchronized ( busStop.getBuses() ) {
                    busLeaving = busStop.getBuses().peekFirst();
                    if (busLeaving.getUid().equals(bus.getUid())) {
                        System.out.println(bus.toString() + " уезжает.");
                        busStop.getBuses().pop();
                        break;
                    }
                }
                Thread.sleep( (int)( Math.random()*200 ));
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
