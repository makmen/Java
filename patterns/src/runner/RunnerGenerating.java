package runner;
//import generating.factorymethod.*;
//import generating.abstractfactory.*;
//import generating.prototype.*;
import generating.builder.*;
/**
 * Created by AMakas on 18.01.2017.
 */
public class RunnerGenerating {
    public static void main(String args[]) {

        /*
        // Factory Method
        Factory factory = new Factory();
        ApptEncoder encoder = factory.getApptEncoder((byte)1);
        System.out.println(encoder.encode());

        Creator creatorMilk = new CreatorMilk();
        Product milk = creatorMilk.factoryMethod();
        System.out.println(milk.toString());
        Creator creatorCoffee = new CreatorCoffee();
        Product coffee = creatorCoffee.factoryMethod();
        System.out.println(coffee.toString());*/
        /*
        // Abstract Method
        TerrainFactory marsFactory = new MarsTerrainFactory();
        MarsSea sea = (MarsSea)marsFactory.getSea();
        IPlain plain = marsFactory.getPlain();
        sea.showSea();
        plain.showPlain();
        */

        // Prototype
        /*TerrainFactoryPrototype factory = new TerrainFactoryPrototype( new EarthSea(), new EarthPlain(), new MarsForest() );
        Sea sea = factory.getSea();
        sea.showSea();
        Plain plain = factory.getPlain();
        plain.showPlain();
        Forest forest = factory.getForest();
        forest.showForest();*/

        User u1 = Director.createUser(new DomBuilder());
        User u2 = Director.createUser(new LomBuilder());

    }
}
