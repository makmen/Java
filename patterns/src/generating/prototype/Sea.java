package generating.prototype;

/**
 * Created by AMakas on 18.01.2017.
 */
public abstract class Sea implements Cloneable  {
    public abstract void showSea();

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
