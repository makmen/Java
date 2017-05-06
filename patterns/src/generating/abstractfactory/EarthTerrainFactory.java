package generating.abstractfactory;

/**
 * Created by AMakas on 18.01.2017.
 */
public class EarthTerrainFactory extends TerrainFactory {
    @Override
    public ISea getSea() {
        return new EarthSea();
    }

    @Override
    public IPlain getPlain() {
        return new EarthPlain();
    }

    @Override
    public IForest getForest() {
        return new EarthForest();
    }
}
