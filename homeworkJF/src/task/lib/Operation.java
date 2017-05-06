package task.lib;

/**
 * Created by AMakas on 27.01.2017.
 */
public class Operation {

    private IStrategy strategy = null;

    private String error = "";

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public IStrategy getStrategy() {
        return this.strategy;
    }

    public double calculation(double a, double b) {
        double output;
        try {
            output = strategy.calculation(a, b);
        } catch (ArithmeticException e) {
            error = e.getMessage();
            output = 0;
        }

        return output;
    }

}
