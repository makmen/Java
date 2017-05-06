package behaving.templatemethod;

/**
 * Created by AMakas on 10.02.2017.
 */
public abstract class Beverage {
    public Beverage() {
        System.out.println(" Konstruct Beverage ");
    }

    public void prepare() {
        boilWater();        // кипятить воду
        brew();             // заварить
        pourInCup();        // перелить в чашку
        addCondiments();         // добавить ингридиенты
    }

    public abstract void brew();

    public abstract void addCondiments();

    public void boilWater() {
        System.out.println("Boiling water");
    }
    public void pourInCup() {
        System.out.println("Pour into cup");
    }
}
