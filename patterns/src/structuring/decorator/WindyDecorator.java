package structuring.decorator;

/**
 * Created by AMakas on 17.02.2017.
 */
public class WindyDecorator extends TileDecorator {
    public WindyDecorator(Tile tile) {
        super(tile);
    }

    @Override
    public int getWealthFactor() {
        return tile.getWealthFactor() + 3;
    }

}
