package tasks.two;

import java.awt.*;

/**
 * Created by AMakas on 20.01.2017.
 */
public class Point {
    private int x;
    private int y;
    private Color color;
    private int delta;

    public int getDelta() {
        return delta;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
    }

    public Point() {
        this.x = (int)(Math.random()*50);
        this.y = (int)(Math.random()*50);
        color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
    }

    public void calcDelta(Point center) {
        double delta = Math.round( Math.sqrt(
                Math.pow((center.x - this.x), 2) +
                        Math.pow((center.y - this.y), 2)
        ));
        this.delta = (int)delta;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                '}';
    }
}
