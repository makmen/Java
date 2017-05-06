package by;

import by.casino.Game;
import by.casino.Player;
import by.compon.Auditorium;
import by.compon.InstrumentalList;
import by.compon.Juggler;
import by.compon.PoeticJuggler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by AMakas on 21.02.2017.
 */
public class Launcher {
    public static void main(String[] args) {
        ApplicationContext cnt = new ClassPathXmlApplicationContext("juggler.xml");

        // объявление компонента используя конструктор по умолчанию
        // или другой конструктор <constructor-arg value="15"></constructor-arg>
        Juggler juggler = (Juggler)cnt.getBean("duke");
        juggler.perfom();

        // внедрение ссылок через конструкторы
        PoeticJuggler poeticJuggler = (PoeticJuggler)cnt.getBean("poeticDuke");
        poeticJuggler.perfom();

        // по умолчанию все компоненты Spring единичны
        // чтобы это изменить используется свойство soope
/*
        Auditorium auditorium = (Auditorium)cnt.getBean("audio");
        InstrumentalList kenny = (InstrumentalList)cnt.getBean("kenny");
        kenny.perfom();
        InstrumentalList kolya = (InstrumentalList)cnt.getBean("kolya");
        kolya.perfom();
        InstrumentalList vasya = (InstrumentalList)cnt.getBean("vasya");
        vasya.perfom();
        InstrumentalList oleg = (InstrumentalList)cnt.getBean("oleg");
        oleg.perfom();
*/

        //Player you = (Player)cnt.getBean("you");
        //Player comp = (Player)cnt.getBean("comp");
        Game game = (Game)cnt.getBean("game");
        game.start();

/*
        String str = game.throwBones();
        System.out.println(str);
        str = game.throwBones();
        System.out.println(str);
*/

        //game.showList();





    }
}
