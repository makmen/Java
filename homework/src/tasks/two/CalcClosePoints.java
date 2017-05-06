package tasks.two;

import java.util.ArrayList;

/**
 * Created by AMakas on 21.01.2017.
 */
public class CalcClosePoints {
    private Point center;
    private ArrayList<Point> listClosePoints;
    private ArrayList<Point> listPoints;

    public ArrayList<Point> getListClosePoints() {
        return listClosePoints;
    }

    public CalcClosePoints(Point center, ArrayList<Point> listPoints) {
        this.center = center;
        this.listPoints = listPoints;
        listClosePoints = new ArrayList<>();
    }

    public void getClosePoints() {
        listClosePoints.add(listPoints.get(0)); // по умолчанию считаем что первая самая близкая
        for (Point point : listPoints) {
            if (listClosePoints.get(0).getDelta() > point.getDelta()) {
                listClosePoints.clear();
                listClosePoints.add(point);
            } else if (listClosePoints.get(0).getDelta() == point.getDelta()) {
                listClosePoints.add(point);
            }
        }
    }

    public void calcAllDelta() {
        for (Point point : listPoints) {
            point.calcDelta(center);
        }
    }
}
