package com.example.student;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class StudentDao 
{
	private Session getSession() {
		
		return  Utility.getSessionFactory().openSession();
	}
	public Student find(int id) {
		Session session=getSession();
		Student s=session.find(Student.class, id);
		return s;
		
	}
	public void saveStudent(Student student) {
		Session session=getSession();
		Transaction tx =session.beginTransaction();
		session.persist(student);
		tx.commit();
		session.close();
		System.out.println("Student Saved Successfully");	
		
	}
	public List<Student> findAll(){
		Session session=getSession();
		List<Student> products=session.createQuery("From Student",Student.class).getResultList();
		return products;
	}
	public void Update(Student s) {
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.merge(s);
		tx.commit();
		session.close();
	}
	public void delete(int id) {
		Session session =getSession();
		Transaction tx= session.beginTransaction();
		Student student = session.get(Student.class,id);
        session.remove(student);
        tx.commit();
        session.close();
        System.out.println("Deleted");
	}

	
}
