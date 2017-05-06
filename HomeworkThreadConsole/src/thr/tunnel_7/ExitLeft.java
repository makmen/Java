package thr.tunnel_7;

/**
 * Created by AMakas on 01.02.2017.
 */
public class ExitLeft extends Exit {

    public ExitLeft() {

    }

    @Override
    public String getNameTunnel() {
        return "левому";
    }

    @Override
    public String getNameMovingTunnel() {
        return "слева направо";
    }
}
