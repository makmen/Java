package db.dao.daoi;

import javafx.collections.ObservableList;
import library.models.Book;

/**
 * Created by AMakas on 08.02.2017.
 */
public interface IBook {

    public boolean set(Book book);

    public boolean delete(Book book);

    public ObservableList<Book> getAll();

    public Book getById(int id);

    public String getError();
}
