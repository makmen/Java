package org.dao.daoi;

import org.entity.Book;
import java.util.List;

/**
 * Created by AMakas on 08.02.2017.
 */
public interface IBook {

    public boolean add(Book book);

    public void delete(Book book);

    public List<Book> getAll();

    public Book getById(int id);

    public List<Book> getByTitle(String string);

    public String getError();
}
