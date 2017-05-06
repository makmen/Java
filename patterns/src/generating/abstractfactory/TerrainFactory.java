package generating.abstractfactory;

/**
 * Created by AMakas on 18.01.2017.
 */
public abstract class TerrainFactory {
    public abstract ISea getSea();
    public abstract IPlain getPlain();
    public abstract IForest getForest();
}
