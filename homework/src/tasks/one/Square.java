package tasks.one;

/**
 * Created by AMakas on 20.01.2017.
 */
public class Square extends Shape{
    private int a;

    public Square() {
        this.a = (int)(Math.random()*15 + 5);
    }

    public double areaShape() {
        return a * a;
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                ", area = " + this.areaShape() +
                '}';
    }
}
