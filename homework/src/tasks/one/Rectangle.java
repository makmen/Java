package tasks.one;

/**
 * Created by AMakas on 20.01.2017.
 */
public class Rectangle extends Shape {
    private int a;
    private int b;

    public Rectangle() {
        this.a = (int)(Math.random()*15 + 5);
        this.b = (int)(Math.random()*15 + 5);
    }

    public double areaShape() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                ", area = " + this.areaShape() +
                '}';
    }
}
