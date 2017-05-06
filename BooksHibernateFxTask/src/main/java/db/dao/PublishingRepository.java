package db.dao;

import db.config.HibernateConnector;
import db.dao.daoi.IPublishing;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.models.Publishing;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by AMakas on 09.02.2017.
 */
public class PublishingRepository implements IPublishing {
    private String lastError;

    public boolean set(Publishing publishing) {
        boolean success = false;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(publishing);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            lastError = ex.getMessage().toString();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return success;
    }

    public boolean delete(Publishing publishing) {
        boolean success = false;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            session.beginTransaction();
            session.delete(publishing);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return success;
    }

    public ObservableList<Publishing> getAll() {
        ObservableList<Publishing> list = FXCollections.observableArrayList();
        List<Publishing> result = null;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<Publishing> criteria = session.getCriteriaBuilder().createQuery(Publishing.class);
            criteria.select( criteria.from(Publishing.class) );
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

    public Publishing getById(int id) {
        return null;
    }

    public String getError() {
        return null;
    }
}
