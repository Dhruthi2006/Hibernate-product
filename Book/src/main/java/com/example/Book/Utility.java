package com.example.Book;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class Utility
{
	private static SessionFactory sessionFactory=new Configuration().configure()
					.addAnnotatedClass(Book.class).buildSessionFactory();
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void shutdown() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
		
}
