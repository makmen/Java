package structuring.decorator;

/**
 * Created by AMakas on 17.02.2017.
 */
public abstract class TileDecorator extends Tile {
    protected Tile tile;
    public TileDecorator(Tile tile) {
        this.tile = tile;
    }

    public void changeTile(Tile tile) {
        this.tile = tile;
    }

}
