package behaving.state;

/**
 * Created by AMakas on 10.02.2017.
 */
public class Port {
    private String name;

    private int currentConteiners;
    public int getCurrentConteiners() {
        return currentConteiners;
    }
    public void setCurrentConteiners(int currentConteiners) {
        this.currentConteiners = currentConteiners;
    }

    public Port(String name, int currentConteiners) {
        this.name = name;
        this.currentConteiners = currentConteiners;
    }

    @Override
    public String toString() {
        return "Port{" +
                "name='" + name + '\'' +
                ", currentConteiners=" + currentConteiners +
                '}';
    }
}
