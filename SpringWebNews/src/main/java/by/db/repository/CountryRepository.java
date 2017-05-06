package by.db.repository;

import by.db.config.HibernateConnector;
import by.system.models.Country;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by AMakas on 07.03.2017.
 */
public class CountryRepository extends Repository {

    public Country getByAbbr(String abbr) {
        Country country = null;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<Country> criteria = session.getCriteriaBuilder().createQuery(Country.class);
            Root<Country> condition = criteria.from(Country.class);
            criteria.select(condition).where(
                    session.getCriteriaBuilder().equal(condition.get("abbr"), abbr)
            );
            country = session.createQuery(criteria).getResultList().get(0);
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return country;
    }

    public List<Country> getAll() {
        List<Country> list = null;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<Country> criteria = session.getCriteriaBuilder().createQuery(Country.class);
            criteria.select( criteria.from(Country.class) );
            list = session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return list;
    }



}
