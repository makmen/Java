package thr.parking_2;

/**
 * Created by AMakas on 30.01.2017.
 */
public class CreatorAuto extends Thread {
    private Parking parking;

    public CreatorAuto( Parking parking ) {
        this.parking = parking;
    }

    private void walking(Car car) {
        System.out.println(car.toString() + " запарковался.");
        try {
            while (true) {
                Thread.sleep( (int)( Math.random()*2000  + 500)); // гуляем
                if ((int)(Math.random()*2) > 0) {
                    parking.leavePark(car);
                    System.out.println(car.toString() + " уехал.");
                    break;
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waiting(Car car) {
        try {
            while (true) {
                if ((int) (Math.random() * 2) > 0) {
                        System.out.println(car.toString() + " не буду ждать, нет мест, уезжаю.");
                    break;
                } else {
                    System.out.println(car.toString() + " ждем...");
                    Thread.sleep( (int)( Math.random()*1000  + 200));
                    if ( parking.parkCar(car) ) {
                        walking(car);
                        break;
                    }
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            Thread.sleep( (int)( Math.random()*4000 + 1000 )); // задержка чтобы не сразу генерил
            Car car = new Car();
            System.out.println(car.toString() + " подъезжает к паркингу.");

            if ( parking.parkCar(car) ) { // если припарковались идем гулять
                walking(car);
            } else {
                waiting(car); // ждем или уезжаем
            }

        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
