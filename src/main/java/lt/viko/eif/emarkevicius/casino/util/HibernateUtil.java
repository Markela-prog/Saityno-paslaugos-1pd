package lt.viko.eif.emarkevicius.casino.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * A utility class that provides methods for creating and accessing a Hibernate SessionFactory object.
 *
 * @author Ernestas
 * @see HibernateUtil
 * @since 1.0
 */
public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    /**
     * Private constructor to prevent instantiation of the HibernateUtil class.
     */
    private HibernateUtil(){

    }

    /**
     * Returns the Hibernate SessionFactory object, creating it if necessary.
     *
     * @return the Hibernate SessionFactory object.
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                registry = new StandardServiceRegistryBuilder().configure().build();

                MetadataSources sources = new MetadataSources(registry);

                Metadata metadata = sources.getMetadataBuilder().build();

                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                shutDown();
            }
        }
        return sessionFactory;
    }

    /**
     * Shuts down the Hibernate registry, releasing any resources it holds.
     */
    public static void shutDown(){
        if(registry != null)
            StandardServiceRegistryBuilder.destroy(registry);
    }
}
