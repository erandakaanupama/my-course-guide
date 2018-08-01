package com.eab.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.demo.entity.Customer;

public class ReadCustomer {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
										.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Customer tempCustomer = new Customer("anj", "bandara", "email"); 
			session.beginTransaction();
			session.save(tempCustomer);
			session.getTransaction().commit();
			
			// read object 
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Customer theCustomer = session.get(Customer.class, tempCustomer.getId());
			System.out.println("done");
		} finally {
			sessionFactory.close();
		}
		
		
	}

}
