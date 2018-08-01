package com.eab.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.demo.entity.Customer;

public class QueryCustomer {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			// start transaction 
			session.beginTransaction();
			
			System.out.println("\nAll customers");
			List<Customer> customers = session.createQuery("from Customer").getResultList(); // .list() for 5.2< hibernate 
			showCustomers(customers);
			
			// last name
			System.out.println("\nLast name");
			customers = session.createQuery("from Customer c where c.lastName='bandara'").getResultList();
			showCustomers(customers);
			
			customers = session.createQuery("from Customer s "
					+ " where s.email like '%mail.com'").getResultList();
			System.out.println("\nemail");
			showCustomers(customers);
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		} finally {
			sessionFactory.close();
		}
	}

	private static void showCustomers(List<Customer> customers) {
		
		for(Customer customer:customers) {
			System.out.println(customer);
		}
		
	}

}
