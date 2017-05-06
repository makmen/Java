package behaving.templatemethod;

/**
 * Created by AMakas on 10.02.2017.
 */
public class Coffee extends Beverage {
    public Coffee() {
        System.out.println("Konstruct Coffee ");
    }
    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }
    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar");
    }
}
