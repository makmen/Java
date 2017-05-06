package org.dao;

import org.config.HibernateLibrary;
import org.dao.daoi.IGroup;
import org.entity.Group;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMakas on 08.02.2017.
 */
public class GroupRepository implements IGroup{
    private String error;
    public String getError() {
        return error;
    }

    public boolean add(Group group) {
        boolean success = false;
        Session session = HibernateLibrary.tryingOpenSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(group);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            error = ex.getMessage();
        } finally {
            HibernateLibrary.tryingCloseSession();
        }

        return success;
    }

    public boolean delete(Group group) {
        boolean success = false;
        Session session = HibernateLibrary.tryingOpenSession();
        try {
            session.beginTransaction();
            session.delete(group);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            error = ex.getMessage();
        } finally {
            HibernateLibrary.tryingCloseSession();
        }

        return success;
    }

    public void update(Group group) {

    }

    public List<Group> getAll() {
        List<Group> list = null;
        Session session = HibernateLibrary.tryingOpenSession();
        try {
            CriteriaQuery<Group> criteria = session.getCriteriaBuilder().createQuery(Group.class);
            criteria.select( criteria.from(Group.class) );
            list = session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            error = ex.getMessage();
        } finally {
            HibernateLibrary.tryingCloseSession();
        }

        return list;
    }

    public Group getById(int id) {
        Group group = null;
        Session session = HibernateLibrary.tryingOpenSession();
        try {
            CriteriaQuery<Group> criteria = session.getCriteriaBuilder().createQuery( Group.class );
            Root<Group> condition = criteria.from( Group.class );
            criteria.select(condition).where(
                session.getCriteriaBuilder().equal( condition.get("id"), id)
            );
            group = session.createQuery(criteria).getResultList().get(0);
        } catch (Exception ex) {
            error = ex.getMessage();
        } finally {
            HibernateLibrary.tryingCloseSession();
        }

        return group;
    }

    public List<Group> getByName(String string) {
        List<Group> list = null;
        Session session = HibernateLibrary.tryingOpenSession();
        try {
            CriteriaQuery<Group> criteria = session.getCriteriaBuilder().createQuery( Group.class );
            Root<Group> condition = criteria.from( Group.class );
            criteria.select(condition).where(
                session.getCriteriaBuilder().equal( condition.get("title"), string )
            );
            list = session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            error = ex.getMessage();
        } finally {
            HibernateLibrary.tryingCloseSession();
        }

        return list;
    }
}
