package com.eab.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.demo.entity.Customer;

public class UpdateCustomer {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			int theId = 1;
			// begin transaction
			session.beginTransaction();
			Customer customer = session.get(Customer.class, theId);

			// update customer
			customer.setEmail("updatemail@mail.com");
			
			// commit transaction
			session.getTransaction().commit();
			
			// create a new session
			session = sessionFactory.getCurrentSession();
			// begin transaction
			session.beginTransaction();

			session.createQuery("update Customer s set s.email='update2@mail.com' where s.firstName='test_first'").executeUpdate();

			// commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("done");

		} finally {
			sessionFactory.close();
		}
	}

}
