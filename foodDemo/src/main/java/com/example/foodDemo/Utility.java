package com.example.foodDemo;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Utility {

    private static SessionFactory factory;


    static {

        factory = new Configuration()
                .configure()
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

    }


    public static SessionFactory getSessionFactory() {
        return factory;
    }
}