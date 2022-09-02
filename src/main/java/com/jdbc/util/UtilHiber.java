package com.jdbc.util;

import com.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class UtilHiber {

    private SessionFactory sessionFactory;

    public UtilHiber() {
        buildSessionFactory();
    }

    private void buildSessionFactory() {
        try {

            //Map<String, Object> settings = new HashMap<>();
            ///settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
            //settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
            //settings.put("hibernate.connection.url",
            //        "jdbc:mysql://localhost:3306/test1");
            //settings.put("hibernate.connection.username", "root");
            //settings.put("hibernate.connection.password", "root");
            //settings.put("hbm2ddl.auto", "create-drop");
            //settings.put("hibernate.current_session_context_class", "thread");
            //settings.put("hibernate.show_sql", "true");
            //settings.put("hibernate.format_sql", "true");

            Configuration configuration = new Configuration();

            configuration.setProperty("connection.driver_class", "com.mysql.jdbc.Driver");
            configuration.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
            configuration.setProperty("hibernate.connection.url",
                    "jdbc:mysql://localhost:3306/test1");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "root");
            configuration.setProperty("hbm2ddl.auto", "create-drop");
            configuration.setProperty("hibernate.current_session_context_class", "thread");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.format_sql", "true");

            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();


            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            //ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            //        .applySettings(settings).build();

           // MetadataSources metadataSources = new MetadataSources(serviceRegistry);

            //metadataSources.addAnnotatedClass(User.class);
            //Metadata metadata = metadataSources.buildMetadata();


            //sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}

