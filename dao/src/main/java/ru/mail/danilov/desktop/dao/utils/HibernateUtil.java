package ru.mail.danilov.desktop.dao.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.mail.danilov.desktop.dao.models.Indications;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                Map<String, String> settings = new HashMap();
                settings.put("hibernate.connection.driver_class", ConfigurationManager.getInstance().getProperty("database.driver.name"));
                settings.put("hibernate.connection.url", ConfigurationManager.getInstance().getProperty("database.url"));
                settings.put("hibernate.connection.username", ConfigurationManager.getInstance().getProperty("database.username"));
                settings.put("hibernate.connection.password", ConfigurationManager.getInstance().getProperty("database.password"));
                settings.put("hibernate.hbm2ddl.auto", ConfigurationManager.getInstance().getProperty("hibernate.hbm2ddl.auto"));
                settings.put("hibernate.dialect", ConfigurationManager.getInstance().getProperty("hibernate.dialect"));
                settings.put("hibernate.current_session_context_class", ConfigurationManager.getInstance().getProperty("hibernate.current_session_context_class"));
                registryBuilder.applySettings(settings);
                registry = registryBuilder.build();
                logger.info("Registry builder created");
                MetadataSources sources = (new MetadataSources(registry))
                        .addAnnotatedClass(Indications.class);
                try {
                    Metadata metadata = sources.getMetadataBuilder().build();
                    sessionFactory = metadata.getSessionFactoryBuilder().build();
                } catch (RuntimeException e) {
                    logger.info("Session factory creating failed");
                    logger.error(e.getMessage(), e);
                }
                logger.info("Session factory created");
            } catch (Exception e) {
                logger.error("Creating session factory failed ");
                logger.error(e.getMessage(), e);
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
}

