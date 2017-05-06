package thr.phaser;

import java.util.concurrent.Phaser;

/**
 * Created by AMakas on 01.02.2017.
 */
public class ThreadPhaser implements Runnable {

    private Phaser phaser;
    private String name;

    public ThreadPhaser(Phaser phaser, String name){
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    public void run(){

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута

        //System.out.println(name + " выполняет фазу " + phaser.getPhase());
        //phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута

        //System.out.println(name + " выполняет фазу " + phaser.getPhase());
        //phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты
    }
}
