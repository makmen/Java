package runner;

import structuring.decorator.*;

/**
 * Created by AMakas on 10.02.2017.
 */
public class RunnerStructuring {
    public static void main(String args[]) {

        /*
        // Adapter

        Duck duck = new Duck();
        duck.fly();
        duck.quack();
        Turkey turkey = new Turkey();
        turkey.fly();
        turkey.gobble();

        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);
        turkeyAdapter.fly();
        turkeyAdapter.quack();
         */
/*
        // Decorator
        Plain plain = new Plain();
        System.out.println( plain.getWealthFactor() );
        Water water = new Water();
        System.out.println( water.getWealthFactor() );
        Desert desert = new Desert();
        System.out.println( desert.getWealthFactor() );

        PollutedPlain pollutedPlain = new PollutedPlain();
        System.out.println( pollutedPlain.getWealthFactor() );
        WindyPlain windyPlain = new WindyPlain();
        System.out.println( windyPlain.getWealthFactor() );

        // вступает в игру декоратор
        PollutedDecorator pollutedDecorator = new PollutedDecorator(plain);
        System.out.println( pollutedDecorator.getWealthFactor() );
        pollutedDecorator.changeTile(water);
        System.out.println( pollutedDecorator.getWealthFactor() );
        pollutedDecorator.changeTile(desert);
        System.out.println( pollutedDecorator.getWealthFactor() );

        WindyDecorator windyDecorator = new WindyDecorator(plain);
        System.out.println( windyDecorator.getWealthFactor() );
        windyDecorator.changeTile(water);
        System.out.println( windyDecorator.getWealthFactor() );
        windyDecorator.changeTile(desert);
        System.out.println( windyDecorator.getWealthFactor() );
*/
        // composite


    }
}
