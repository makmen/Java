package by;

import by.test.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by AMakas on 22.02.2017.
 */
public class Launcher {
    public static void main(String[] args) {
/*        ApplicationContext cnt = new ClassPathXmlApplicationContext("config.xml");

        Musician olga = (Musician)cnt.getBean(Musician.class);
        olga.perfom();

        Musician igor = (Musician)cnt.getBean(Musician.class);
        igor.perfom();*/

        ApplicationContext cnt = new AnnotationConfigApplicationContext(AppConfig.class);

        Juggler duke = cnt.getBean(Juggler.class);
        System.out.println(duke);

        Juggler duke1 = cnt.getBean(Juggler.class);
        System.out.println(duke1);

        JagglerSmaty kenny = cnt.getBean(JagglerSmaty.class);
        kenny.perfom();

        JagglerSing olga = cnt.getBean(JagglerSing.class);
        olga.perfom();

        JugglerMusician oleg = cnt.getBean(JugglerMusician.class);
        System.out.println(oleg);
        oleg.perfom();

        JugglerMusician oleg2 = cnt.getBean(JugglerMusician.class);
        System.out.println(oleg2);
        oleg2.perfom();

    }
}
