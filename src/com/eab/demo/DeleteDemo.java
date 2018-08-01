package com.eab.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.demo.entity.Instructor;
import com.eab.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			int theId = 1; 
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, theId);
			session.delete(instructor);
			
			session.getTransaction().commit();
			System.out.println("delete complete");
			
		} finally {
			
			sessionFactory.close();
		}
	
	}

}
