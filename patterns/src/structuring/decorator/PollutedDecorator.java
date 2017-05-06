package structuring.decorator;

/**
 * Created by AMakas on 17.02.2017.
 */
public class PollutedDecorator extends TileDecorator {
    public PollutedDecorator(Tile tile) {
        super(tile);
    }

    @Override
    public int getWealthFactor() {
        return tile.getWealthFactor() + 2;
    }
}
