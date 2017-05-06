package db.dao;

import db.config.HibernateConnector;
import db.dao.daoi.IGenre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.models.Genre;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by AMakas on 09.02.2017.
 */
public class GenreRepository implements IGenre {
    private String lastError;

    public boolean set(Genre genre) {
        boolean success = false;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(genre);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            lastError = ex.getMessage().toString();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return success;
    }

    public boolean delete(Genre genre) {
        boolean success = false;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            session.beginTransaction();
            session.delete(genre);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return success;
    }

    public ObservableList<Genre> getAll() {
        ObservableList<Genre> list = FXCollections.observableArrayList();
        List<Genre> result = null;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<Genre> criteria = session.getCriteriaBuilder().createQuery(Genre.class);
            criteria.select( criteria.from(Genre.class) );
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

    public Genre getById(int id) {
        return null;
    }

    public String getError() {
        return lastError;
    }
}
