package lt.viko.eif.emarkevicius.casino.util;

import lt.viko.eif.emarkevicius.casino.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * A utility class that provides methods for saving a Casino object to a database using Hibernate.
 *
 * @author Ernestas
 * @see HibernateApp
 * @since 1.0
 */
public final class HibernateApp {

    /**
     * Private constructor to prevent instantiation of the HibernateApp class.
     */
    private HibernateApp() {

    }

    /**
     * Saves a Casino object to a database using Hibernate.
     *
     * @param casino the Casino object to be saved.
     */
    public static void saveToDatabase(Casino casino) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(casino);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}