package behaving.observer;

import java.util.ArrayList;

/**
 * Created by AMakas on 10.02.2017.
 */
public class AuctionObserver implements IObserver  {
    private ArrayList<Participant> participants = new ArrayList<>();

    @Override
    public void attach(Participant participant) {
        participants.add(participant);
    }

    @Override
    public void detach(Participant participant) {
        for (Participant item : participants) {
            if (item.getId() == participant.getId()) {
                participants.remove(item);
                break;
            }
        }
    }

    @Override
    public void notifyParticipant(String message) {
        for (Participant item : participants) {
            System.out.println(item.toString() + message);
        }
    }
}
