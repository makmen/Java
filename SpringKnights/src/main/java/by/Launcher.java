package by;

import by.kniga.Knight;
import by.quest.DrinkQuest;
import by.quest.KillDragonQuest;
import by.quest.RescueQuestDama;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by AMakas on 21.02.2017.
 */
public class Launcher {

    public static void main(String[] args) {

        ApplicationContext cnt = new AnnotationConfigApplicationContext(AppConfig.class);
        Knight knight = cnt.getBean(Knight.class);
        knight.doQuest();
        knight.setQuest(new DrinkQuest());
        knight.doQuest();

    }

}
