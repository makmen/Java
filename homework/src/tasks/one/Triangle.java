package tasks.one;

/**
 * Created by AMakas on 20.01.2017.
 */
public class Triangle extends Shape {
    private int a;
    private int b;
    private int c;

    public Triangle() {
        this.a = (int)(Math.random()*15 + 5);
        this.b = (int)(Math.random()*15 + 5);
        this.c = (int)(Math.random()*15 + 5);
    }
    public double areaShape() {
        double p = (a + b + c) / 2;
        return Math.sqrt( p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", area = " + this.areaShape() +
                '}';
    }
}
