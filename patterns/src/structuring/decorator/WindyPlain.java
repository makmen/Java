package structuring.decorator;

/**
 * Created by AMakas on 17.02.2017.
 */
public class WindyPlain extends Plain {
    public int getWealthFactor() {
        return super.getWealthFactor() + 3;
    }
}
