package tasks.one;

/**
 * Created by AMakas on 20.01.2017.
 */
public class Trapeze extends Shape {
    private int a;
    private int b;
    private int h;

    public Trapeze() {
        this.a = (int)(Math.random()*15 + 5);
        this.b = (int)(Math.random()*15 + 5);
        this.h = (int)(Math.random()*15 + 5);
    }
    public double areaShape() {
        return (a + b) * h / 2 ;
    }

    @Override
    public String toString() {
        return "Trapeze{" +
                "a=" + a +
                ", b=" + b +
                ", h=" + h +
                ", area = " + this.areaShape() +
                '}';
    }
}
