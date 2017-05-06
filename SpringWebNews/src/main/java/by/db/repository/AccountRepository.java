package by.db.repository;

import by.db.config.HibernateConnector;
import by.system.models.Account;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by AMakas on 07.03.2017.
 */
public class AccountRepository extends Repository {

    public Account getByLogin(String login) {
        Account account = null;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<Account> criteria = session.getCriteriaBuilder().createQuery(Account.class);
            Root<Account> condition = criteria.from(Account.class);
            criteria.select(condition).where(
                    session.getCriteriaBuilder().equal(condition.get("login"), login)
            );
            account = session.createQuery(criteria).getResultList().get(0);
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return account;
    }

    public Account getAccount(String login, String password) {
        Account account = null;
        Session session = HibernateConnector.tryingOpenSession();
        try {
            CriteriaQuery<Account> criteria = session.getCriteriaBuilder().createQuery(Account.class);
            Root<Account> condition = criteria.from(Account.class);
            criteria.select(condition).where(
                    session.getCriteriaBuilder().equal(condition.get("login"), login),
                    session.getCriteriaBuilder().equal(condition.get("password"), password)
            );
            account = session.createQuery(criteria).getResultList().get(0);
        } catch (Exception ex) {
            lastError = ex.getMessage();
        } finally {
            HibernateConnector.tryingCloseSession();
        }

        return account;
    }

    /*public AccountRepository() {
        HibernateConnector.tryingOpenSession();
    }*/

}
