package db.dao.daoi;

import javafx.collections.ObservableList;
import library.models.Publishing;


/**
 * Created by AMakas on 08.02.2017.
 */
public interface IPublishing {

    public boolean set(Publishing publishing);

    public boolean delete(Publishing publishing);

    public ObservableList<Publishing> getAll();

    public Publishing getById(int id);

    public String getError();
}
