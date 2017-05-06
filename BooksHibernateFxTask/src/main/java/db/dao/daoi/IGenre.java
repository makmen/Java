package db.dao.daoi;

import javafx.collections.ObservableList;
import library.models.Genre;

import java.util.List;

/**
 * Created by AMakas on 08.02.2017.
 */
public interface IGenre {

    public boolean set(Genre genre);

    public boolean delete(Genre genre);

    public ObservableList<Genre> getAll();

    public Genre getById(int id);

    public String getError();
}
