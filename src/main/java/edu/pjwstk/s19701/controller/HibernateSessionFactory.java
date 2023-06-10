package edu.pjwstk.s19701.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Class enabling factory to manage session
 */
public class HibernateSessionFactory {

    private HibernateSessionFactory(){
        // Session Factory utility class
        // java:S1118 - Utility classes should not have public constructors
        // https://rules.sonarsource.com/java/RSPEC-1118
    }
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                registry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    @SuppressWarnings("java:S2259")
    public static Session getOrOpenSession() {
        if (getSessionFactory().isOpen() && getSessionFactory().getCurrentSession().isOpen()) {
            return getSessionFactory().getCurrentSession();
        } else {
            return getSessionFactory().openSession();
        }
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}