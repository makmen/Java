package by;

import by.auto.Musician;
import by.test.Player;
import by.test.PoeticJuggler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by AMakas on 22.02.2017.
 */
public class Launcher {
    public static void main(String[] args) {

        ApplicationContext cnt = new ClassPathXmlApplicationContext("config.xml");
        /*Player kenny = (Player)cnt.getBean("kenny");
        kenny.perfom();

        Player kolya = (Player)cnt.getBean("kolya");
        kolya.perfom();

        Player vasya = (Player)cnt.getBean("vasya");
        vasya.perfom();

        Player oleg = (Player)cnt.getBean("oleg");
        oleg.perfom();

        PoeticJuggler duke = (PoeticJuggler)cnt.getBean("duke");
        duke.perfom();*/

        Musician olga = (Musician)cnt.getBean("olga");
        olga.perfom();


    }
}
