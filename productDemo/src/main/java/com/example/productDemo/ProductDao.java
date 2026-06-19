package com.example.productDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class ProductDao 
{
	private Session getSession() {
		
		return  Utility.getSessionFactory().openSession();
	}
	public Product find(int id) {
		Session session=getSession();
		Product p=session.find(Product.class, id);
		return p;
		
	}
	public void saveProduct(Product product) {
		Session session=getSession();
		Transaction tx =session.beginTransaction();
		session.persist(product);
		tx.commit();
		session.close();
		System.out.println("Product Saved Successfully");	
		
	}
	public List<Product> findAll(){
		Session session=getSession();
		List<Product> products=session.createQuery("From Product",Product.class).getResultList();
		return products;
	}
	public void Update(Product p) {
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.merge(p);
		tx.commit();
		session.close();
	}
	public void delete(int id) {
		Session session =getSession();
		Transaction tx= session.beginTransaction();
        Product product = session.get(Product.class,id);
        session.remove(product);
        tx.commit();
        session.close();
        System.out.println("Deleted");
	}

	
}
