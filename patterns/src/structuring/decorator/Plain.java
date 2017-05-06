package structuring.decorator;

/**
 * Created by AMakas on 17.02.2017.
 */
public class Plain extends Tile {
    private int welathFactor = 2;

    @Override
    public int getWealthFactor() {
        return welathFactor;
    }
}
