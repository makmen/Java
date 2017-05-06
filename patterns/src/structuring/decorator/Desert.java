package structuring.decorator;

/**
 * Created by AMakas on 17.02.2017.
 */
public class Desert extends Tile{
    private int welathFactor = 6;

    @Override
    public int getWealthFactor() {
        return welathFactor;
    }
}
