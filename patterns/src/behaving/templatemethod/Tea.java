package behaving.templatemethod;

/**
 * Created by AMakas on 10.02.2017.
 */
public class Tea extends Beverage {
    public Tea() {
        System.out.println("Konstruct Tea ");
    }
    @Override
    public void brew() {
        System.out.println("Steeping Tea");
    }
    @Override
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
