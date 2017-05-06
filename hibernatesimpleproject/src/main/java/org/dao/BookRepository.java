package org.dao;

import org.config.HibernateLibrary;
import org.dao.daoi.IBook;
import org.entity.Book;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by AMakas on 08.02.2017.
 */
public class BookRepository implements IBook {
    private String error;

    public boolean add(Book book) {
        boolean success = false;
        Session session = HibernateLibrary.tryingOpenSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(book);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            error = ex.getMessage();
        } finally {
            HibernateLibrary.tryingCloseSession();
        }

        return success;
    }

    public void delete(Book book) {

    }

    public List<Book> getAll() {
        return null;
    }

    public Book getById(int id) {
        return null;
    }

    public List<Book> getByTitle(String string) {
        return null;
    }

    public String getError() {
        return null;
    }
}
