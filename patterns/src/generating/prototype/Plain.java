package generating.prototype;

/**
 * Created by AMakas on 18.01.2017.
 */
public abstract class Plain implements Cloneable {
    public abstract void showPlain();
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
