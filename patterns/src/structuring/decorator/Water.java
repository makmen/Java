package structuring.decorator;

/**
 * Created by AMakas on 17.02.2017.
 */
public class Water extends Tile {
    private int welathFactor = 4;

    @Override
    public int getWealthFactor() {
        return welathFactor;
    }
}
