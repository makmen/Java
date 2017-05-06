package behaving.observer;

import java.util.UUID;

/**
 * Created by AMakas on 10.02.2017.
 */
public class Bid {
    private UUID id;

    private double price;
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        message = "Изменение цены с " + this.price + " на " + price;
        this.price = price;

        update();
    }

    private String name;
    public String getName() {
        return name;
    }

    private String message;
    private AuctionObserver observer = new AuctionObserver();

    public Bid(String name, double price) {
        id = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public void addParticipant(Participant participant) {
        observer.attach(participant);
    }

    public void removeParticipant(Participant participant) {
        observer.detach(participant);
    }

    public void update() {
        observer.notifyParticipant(message);
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", prive=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
