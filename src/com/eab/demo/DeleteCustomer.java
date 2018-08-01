package com.eab.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.demo.entity.Customer;

public class DeleteCustomer {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			session.createQuery("delete from Customer where id=1").executeUpdate();
			session.getTransaction().commit();
			System.out.println("done");
			
		} finally {
			sessionFactory.close();
		}
	}

}
