package by.compon;

/**
 * Created by AMakas on 21.02.2017.
 */
public class PoeticJuggler extends Juggler{
    private IPoem poem;

    public PoeticJuggler(IPoem poem) {
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, IPoem poem) {
        super(beanBags);
        this.poem = poem;
    }

    @Override
    public void perfom() {
        super.perfom();
        System.out.println("While reciting...");
        poem.recite();
    }
}
