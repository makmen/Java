package generating.abstractfactory;

/**
 * Created by AMakas on 18.01.2017.
 */
public class MarsTerrainFactory extends TerrainFactory {
    @Override
    public ISea getSea() {
        return new MarsSea();
    }

    @Override
    public IPlain getPlain() {
        return new MarsPlain();
    }

    @Override
    public IForest getForest() {
        return new MarsForest();
    }
}
