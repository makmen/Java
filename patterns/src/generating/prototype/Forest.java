package generating.prototype;

/**
 * Created by AMakas on 18.01.2017.
 */
public abstract class Forest implements Cloneable {
    public abstract void showForest();
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
