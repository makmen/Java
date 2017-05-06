package behaving.state;

/**
 * Created by AMakas on 10.02.2017.
 */
public class StartState implements IState {
    @Override
    public void someAction() {
        System.out.println("StartState");
    }
}
