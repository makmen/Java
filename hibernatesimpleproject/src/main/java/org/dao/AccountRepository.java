package org.dao;

import org.config.HibernateLibrary;
import org.dao.daoi.IAccount;
import org.entity.Account;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by AMakas on 08.02.2017.
 */
public class AccountRepository implements IAccount {
    private String error;
    public String getError() {
        return error;
    }

    public boolean add(Account account) {
        boolean success = false;
        Session session = HibernateLibrary.tryingOpenSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(account);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            error = ex.getMessage();
        } finally {
            HibernateLibrary.tryingCloseSession();
        }

        return success;
    }

    public void delete(Account account) {


    }

    public void update(Account account) {

    }

    public List<Account> getAll() {
        List<Account> list = null;
        Session session = HibernateLibrary.tryingOpenSession();
        try {
            CriteriaQuery<Account> criteria = session.getCriteriaBuilder().createQuery(Account.class);
            criteria.select( criteria.from(Account.class) );
            list = session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            error = ex.getMessage();
        } finally {
            HibernateLibrary.tryingCloseSession();
        }

        return list;
    }

    public Account getById(int id) {
        Account account = null;
        Session session = HibernateLibrary.tryingOpenSession();
        try {
            CriteriaQuery<Account> criteria = session.getCriteriaBuilder().createQuery( Account.class );
            Root<Account> condition = criteria.from( Account.class );
            criteria.select(condition).where(
                    session.getCriteriaBuilder().equal( condition.get("id"), id)
            );
            account = session.createQuery(criteria).getResultList().get(0);
        } catch (Exception ex) {
            error = ex.getMessage();
        } finally {
            HibernateLibrary.tryingCloseSession();
        }

        return account;
    }

    public List<Account> getByName(String string) {
        return null;
    }
}
