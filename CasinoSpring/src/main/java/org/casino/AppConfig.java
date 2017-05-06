package org.casino;

import org.casino.beans.Bone;
import org.casino.beans.IBones;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by AMakas on 20.02.2017.
 */
@Configuration
@ComponentScan(basePackages = "org.casino")
public class AppConfig {

    @Bean
    @Scope("prototype")
    public IBones getBone() {
        return new Bone();
    }

}
