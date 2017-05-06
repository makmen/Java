package behaving.state;

/**
 * Created by AMakas on 10.02.2017.
 */
public class Context {
    private IState state;

    public IState getState() {
        return state;
    }
    public void setState(IState state) {
        this.state = state;
    }

    public Context(IState state) {
        this.state = state;
    }

    public void chnageStateRequest() {
        state.someAction();
    }
}
