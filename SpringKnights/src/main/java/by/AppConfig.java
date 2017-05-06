package by;

import by.kniga.Knight;
import by.quest.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by AMakas on 21.02.2017.
 */
@Configuration
public class AppConfig {
    @Bean
    public IQuest getQuest() {
        return new RescueQuestDama();
    }

    @Bean
    public Knight knight() {
        return new Knight(getQuest());
    }

}
