package by.db.repository;

import by.db.config.HibernateConnector;
import by.system.models.News;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by AMakas on 13.03.2017.
 */
public class NewsRepository extends Repository {

    private int limit = 5;
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<News> getAll() {
        List<News> list = null;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<News> criteria = session.getCriteriaBuilder().createQuery(News.class);
            criteria.select( criteria.from(News.class) );
            list = session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return list;
    }

    public News getById(int id) {
        News news = null;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<News> criteria = session.getCriteriaBuilder().createQuery(News.class);
            Root<News> condition = criteria.from( News.class );
            criteria.select(condition).where(
                session.getCriteriaBuilder().equal( condition.get("id"), id)
            );
            news = session.createQuery(criteria).getResultList().get(0);
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return news;
    }

    public int getTotalNews() {
        int totalNews = 0;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<News> criteria = session.getCriteriaBuilder().createQuery(News.class);
            criteria.select( criteria.from(News.class) );
            totalNews = session.createQuery(criteria).getResultList().size();
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return totalNews;
    }

    public List<News> getAllLimit(int offset) {
        List<News> list = null;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<News> criteria = session.getCriteriaBuilder().createQuery(News.class);
            Root<News> condition = criteria.from( News.class );
            criteria.select(condition).orderBy(
                session.getCriteriaBuilder().desc( condition.get("registed") )
            );
            list = session.createQuery(criteria).
                    setFirstResult(offset).
                    setMaxResults(limit).
                    getResultList();
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return list;
    }



}
