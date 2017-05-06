package thr;

import com.sun.jmx.remote.internal.ClientNotifForwarder;
import thr.Bank_5.Client;
import thr.Bank_5.Bank;
import thr.Bank_5.Repository;
import thr.bus_1.Bus;
import thr.bus_1.BusStop;
import thr.bus_1.CreatorBus;
import thr.callcenter_3.CallCenter;
import thr.callcenter_3.CreatorCustomer;
import thr.parking_2.CreatorAuto;
import thr.parking_2.Parking;
import thr.phaser.ThreadPhaser;
import thr.port_6.Port;
import thr.port_6.Ship;
import thr.producer.Consumer;
import thr.producer.Producer;
import thr.producer.Store;
//import thr.restaurant_4.Client;
import thr.restaurant_4.CreatorClients;
import thr.restaurant_4.Restaurant;
import thr.sema.CommonResource;
import thr.sema.CountThread;
//import thr.tunnelPhaser.Tunnel;
//import thr.tunnelPhaser.Train;
import thr.tunnel_7.Train;
import thr.tunnel_7.Tunnel;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

/**
 * Created by AMakas on 30.01.2017.
 */
public class Launcher {
    static public void main(String agrs[]) {

/*
        // 1. Автобусная остановка. На  одной остановке  может  останавливаться  несколько  автобусов  одновременно.
        // Автобусы выстраиваются в очередь, автобусы не могут уехать, до тех пор, пока передние не уедут.
        BusStop busStop = new BusStop();
        for (int i = 0; i < 100; i++) {
            new Thread( new CreatorBus(busStop) ).start();
        }
*/

/*
        // 2. Автостоянка. Доступно несколько машино-мест. На одном месте может находиться только один автомобиль.
        // Если все места заняты, то автомобиль может подождать немного или уехать на другую стоянку.
        Parking parking = new Parking();
        for (int i = 0; i < 50; i++) {
            new Thread( new CreatorAuto(parking) ).start();
        }
*/



/*
        // 3. CallCenter. В организации работает несколько операторов.
        // Оператор может обслуживать только одного клиента, остальные должны ждать своей очереди.
        CallCenter callCenter = new CallCenter();
        for (int i = 0; i < 40; i++) {
            new Thread( new CreatorCustomer(callCenter) ).start();
        }
*/

/*
        // 4. Свободная  касса.  В  ресторане  быстрого  обслуживания  есть  несколько касс.
        // Посетители  стоят  в  очереди  в  конкретную  кассу.
        Restaurant restaurant = new Restaurant();
        for (int i = 0; i < 50; i++) {
            new Client(restaurant);
        }
        for (int i = 0; i < 50; i++) {
            new Client(restaurant);
            if ((int)(Math.random()*2) == 0) {
                try {
                    Thread.sleep((int) (Math.random() * 2000 + 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
*/
/*
// 5. Банк. Имеется банк с кассирами, клиентами и их счетами. Клиент может снимать/пополнять/переводить/оплачивать/обменивать
//  денежные  средства.  Кассир  последовательно  обслуживает  клиентов.
// Поток-наблюдатель следит, чтобы в кассах всегда были наличные, при скоплении денег более определенной суммы,
// часть их переводится в хранилище, при истощении запасов наличных происходит пополнение из хранилища.
        Bank bank = new Bank( new Repository() );
        for (int i = 0; i < 40; i++) {
            new Client(bank);
        }
*/


// 6. Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент
// в порту и на корабле, должно быть неотрицательным и превышающим заданную грузоподъемность судна и вместимость порта.
// В порту работает несколько причалов. У одного причала может стоять один корабль.
// Корабль может загружаться у причала,  разгружаться или выполнять оба действия.
        Port port = new Port();
        for (int i = 0; i < 40; i++) {
            new Ship(port);
        }
        for (int i = 0; i < 120; i++) {
            new Ship(port);
            if ((int)(Math.random()*2) == 0) {
                try {
                    Thread.sleep((int) (Math.random() * 3000 + 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


// 7. Тоннель. В горах существует железнодорожный тоннель, по которому поезда могут двигаться в обоих направлениях.
// По обоим концам тоннеля собралось много поездов. Обеспечить безопасное прохождение  тоннелей в  обоих  направлениях.
// Поезд  можно  перенаправить  из  одного  тоннеля в другой по очереди.
/*
        Tunnel tunnel = new Tunnel();
        for (int i = 0; i < 20; i++) {
            new Train(tunnel);
        }
        for (int i = 0; i < 30; i++) {
            new Train(tunnel);
            if ((int)(Math.random()*2) == 0) {
                try {
                    Thread.sleep((int) (Math.random() * 3000 + 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
*/
// используем Phaser для решения 7 задачи
/*
        Tunnel tunnel = new Tunnel();
        for (int i = 0; i < 10; i++) {
            new Train(tunnel);
        }
        for (int i = 0; i < 20; i++) {
            new Train(tunnel);
            if ((int)(Math.random()*2) == 0) {
                try {
                    Thread.sleep((int) (Math.random() * 3000 + 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
*/
/*
        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();

*/

/*
        Semaphore sem = new Semaphore(1);
        CommonResource commonResource = new CommonResource();
        new Thread(new CountThread(commonResource, sem, "One")).start();
        new Thread(new CountThread(commonResource, sem, "Two")).start();
        new Thread(new CountThread(commonResource, sem, "Three")).start();
*/

/*
        Phaser phaser = new Phaser(1);
        new Thread(new ThreadPhaser(phaser, "PhaseThread 1")).start();
        new Thread(new ThreadPhaser(phaser, "PhaseThread 2")).start();
        //phaser.arriveAndAwaitAdvance();

        phaser.arriveAndDeregister();
*/


    }
}
