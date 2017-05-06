package structuring.decorator;

/**
 * Created by AMakas on 17.02.2017.
 */
public class PollutedPlain extends Plain {
    public int getWealthFactor() {
        return super.getWealthFactor() + 2;
    }
}
