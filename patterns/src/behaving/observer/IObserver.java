package behaving.observer;

/**
 * Created by AMakas on 10.02.2017.
 */
public interface IObserver {
    public void attach (Participant participant);
    public void detach (Participant participant);
    public void notifyParticipant(String message);
}
