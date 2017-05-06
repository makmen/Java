package tasks.one;

/**
 * Created by AMakas on 20.01.2017.
 */
public class Circle extends Shape {
    private int r;

    public Circle() {
        this.r = (int)(Math.random()*15 + 5);
    }

    public double areaShape() {
        return Math.PI *  this.r * this.r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                ", area = " + this.areaShape() +
                '}';
    }
}
