package generating.factorymethod;

/**
 * Created by AMakas on 18.01.2017.
 */
public class Factory {
    private final byte BLOGGS = 1;
    private final byte MEGA = 2;
    private final byte RDA = 3;

    public ApptEncoder getApptEncoder(byte mode) {
        switch (mode) {
            case MEGA:
                return new MegaApptEncoder();
            case BLOGGS:
                return new BloggsApptEncoder();
            default:
                return new RdaApptEncoder();
        }
    }

}
