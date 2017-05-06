package by;

import by.test.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * Created by AMakas on 22.02.2017.
 */
@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    //
    public IInstrument getAccordion() {
        return new Accordion();
    }

    @Bean
    @Scope("prototype")
    @Primary
    public IInstrument getPiano() {
        return new Piano();
    }

    @Bean
    @Scope("prototype")
    public JugglerMusician music() {
        //JugglerMusician musician = new JugglerMusician(  );
        //musician.setInstrument( getAccordion() );

        //return musician;
        return new JugglerMusician();
    }

    @Bean
    @Scope("prototype")
    public JagglerSing song() {
        return new JagglerSing("kolp");
    }

    @Bean
    @Scope("prototype")
    public Juggler duke() {
        return new Juggler();
    }

    @Bean
    @Scope("prototype")
    public JagglerSmaty smarty() {
        return new JagglerSmaty();
    }

}
