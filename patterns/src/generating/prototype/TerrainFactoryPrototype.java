package generating.prototype;

/**
 * Created by AMakas on 18.01.2017.
 */
public class TerrainFactoryPrototype {
    private Sea sea;
    private Plain plain;
    private Forest forest;

    public TerrainFactoryPrototype(Sea sea, Plain plain, Forest forest) {
        this.sea = sea;
        this.plain = plain;
        this.forest = forest;
    }
    public Sea getSea() {
        Sea clon = null;
        try {
            clon = (Sea)sea.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clon;
    }
    public Plain getPlain() {
        Plain clon = null;
        try {
            clon = (Plain)plain.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clon;
    }
    public Forest getForest() {
        Forest clon = null;
        try {
            clon = (Forest)forest.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clon;
    }
}
