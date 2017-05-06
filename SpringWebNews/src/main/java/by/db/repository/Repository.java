package by.db.repository;

import by.db.config.HibernateConnector;
import by.system.models.Account;
import by.system.models.Country;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaQuery;

import java.util.List;

/**
 * Created by AMakas on 07.03.2017.
 */
public class Repository implements IRepository {
    protected String lastError;

    public <T> boolean set(T entity) {
        boolean success = false;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return success;
    }





}
