package by.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by AMakas on 21.02.2017.
 */
@Component
@Scope("prototype")
public interface IInstrument {
    String play();
}
