package com.example.foodDemo;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class OrderDao {


    private Session getSession(){

        return Utility.getSessionFactory().openSession();

    }



    // CREATE

    public void saveOrder(Order order){

        Session session=getSession();

        Transaction tx=session.beginTransaction();

        session.persist(order);

        tx.commit();

        session.close();

        System.out.println("Order Saved Successfully");

    }



    // READ

    public Order find(int id){

        Session session=getSession();

        Order o=session.find(Order.class,id);

        session.close();

        return o;
    }



    // READ ALL

    public List<Order> findAll(){

        Session session=getSession();

        List<Order> list=session
                .createQuery("from Order",Order.class)
                .list();

        session.close();

        return list;

    }



    // UPDATE

    public void update(Order order){

        Session session=getSession();

        Transaction tx=session.beginTransaction();

        session.merge(order);

        tx.commit();

        session.close();

        System.out.println("Updated Successfully");

    }




    // DELETE

    public void delete(int id){

        Session session=getSession();

        Transaction tx=session.beginTransaction();


        Order o=session.find(Order.class,id);


        if(o!=null){

            session.remove(o);
            System.out.println("Deleted Successfully");

        }
        else{

            System.out.println("Order not found");

        }


        tx.commit();

        session.close();

    }

}