package com.example.Book;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class BookDao 
{
	private Session getSession() {
		
		return  Utility.getSessionFactory().openSession();
	}
	public Book find(int id) {
		Session session=getSession();
		Book p=session.find(Book.class, id);
		return p;
		
	}
	public void saveProduct(Book book) {
		Session session=getSession();
		Transaction tx =session.beginTransaction();
		session.persist(book);
		tx.commit();
		session.close();
		System.out.println("Product Saved Successfully");	
		
	}
	public List<Book> findAll(){
		Session session=getSession();
		List<Book> products=session.createQuery("From Book",Book.class).getResultList();
		return products;
	}
	public void Update(Book b) {
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.merge(b);
		tx.commit();
		session.close();
	}
	public void delete(int id) {
		Session session =getSession();
		Transaction tx= session.beginTransaction();
        Book book = session.get(Book.class,id);
        session.remove(book);
        tx.commit();
        session.close();
        System.out.println("Deleted");
	}

	
}
