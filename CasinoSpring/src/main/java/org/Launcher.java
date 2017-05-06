package org;

import org.casino.AppConfig;
import org.casino.beans.Casino;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by AMakas on 20.02.2017.
 */
public class Launcher {
    public static void main(String[] args) {
        ApplicationContext cnt = new AnnotationConfigApplicationContext(AppConfig.class);
        Casino casino = cnt.getBean(Casino.class);
        System.out.println(casino);

        Casino casino1 = cnt.getBean(Casino.class);
        System.out.println(casino1);
        casino.throwBones();
        casino1.throwBones();


        casino.throwBones();

        casino = cnt.getBean(Casino.class);
        System.out.println(casino);
        casino.throwBones();


    }
}
