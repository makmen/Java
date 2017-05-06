package db.dao;

import db.config.HibernateConnector;
import db.dao.daoi.IBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.models.Book;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by AMakas on 08.02.2017.
 */
public class BookRepository implements IBook {
    private String lastError;

    public boolean set(Book book) {
        boolean success = false;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(book);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return success;
    }

    public boolean delete(Book book) {
        boolean success = false;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return success;
    }

    public ObservableList<Book> getAll() {
        ObservableList<Book> list = FXCollections.observableArrayList();
        List<Book> result = null;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<Book> criteria = session.getCriteriaBuilder().createQuery(Book.class);
            criteria.select( criteria.from(Book.class) );
            result = session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }
        if (result != null) {
            list.setAll(result);
        }

        return list;
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
