package by.db.dao;

import by.begin.models.Anketa;
import by.db.dao.daoi.IAnketa;
import by.db.config.HibernateConnector;

import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by AMakas on 08.02.2017.
 */
public class AnketaRepository implements IAnketa {
    private String lastError;

    public AnketaRepository() {

    }

    public boolean set(Anketa anketa) {
        boolean success = false;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(anketa);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return success;
    }

    public boolean delete(Anketa anketa) {
        /*boolean success = false;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            session.beginTransaction();
            session.delete(anketa);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return success;*/
        return false;
    }

    public ObservableList<Anketa> getAll() {
       /* ObservableList<Anketa> list = FXCollections.observableArrayList();
        List<Anketa> result = null;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<Anketa> criteria = session.getCriteriaBuilder().createQuery(Anketa.class);
            criteria.select( criteria.from(Anketa.class) );
            result = session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }
        if (result != null) {
            list.setAll(result);
        }

        return list;*/
       return null;
    }

    public Anketa getById(int id) {
        return null;
    }

    public List<Anketa> getByTitle(String string) {
        return null;
    }

    public String getError() {
        return null;
    }
}
