package db.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * Created by AMakas on 08.02.2017.
 */
public class HibernateConnector {

    private static final SessionFactory sessionFactory = buildingFactory();

    private static Session session;

    public static Session getSession() {
        return session;
    }

    private static SessionFactory buildingFactory() {
        SessionFactory sessionFactory = null;
        String path = new File("").getAbsolutePath();
        path += File.separator + "target" + File.separator + "classes" + File.separator;
        try {
            sessionFactory = new Configuration().configure(
                new File(path + "hibernate.cfg.xml")
            ).buildSessionFactory();
        } catch (Exception ex) {
            sessionFactory = null;
        }

        return sessionFactory;
    }

    public static Session tryingOpenSession() {
        session = null;
        if (sessionFactory != null) {
            session = sessionFactory.openSession();
        }

        return session;
    }

    public static void tryingCloseSession() {
        if (session != null) {
            session.close();
        }
    }

    public static void shutDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

}
