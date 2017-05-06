package behaving.observer;

import java.util.UUID;

/**
 * Created by AMakas on 10.02.2017.
 */
public class Participant {
    private UUID id;
    public UUID getId() {
        return id;
    }

    private String name;
    public String getName() {
        return name;
    }

    public Participant(String name) {
        id = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
