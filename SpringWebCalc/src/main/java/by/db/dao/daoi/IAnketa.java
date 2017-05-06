package by.db.dao.daoi;

import by.begin.models.Anketa;
import javafx.collections.ObservableList;

/**
 * Created by AMakas on 08.02.2017.
 */
public interface IAnketa {

    boolean set(Anketa anketa);

    boolean delete(Anketa anketa);

    ObservableList<Anketa> getAll();

    Anketa getById(int id);

    String getError();
}
