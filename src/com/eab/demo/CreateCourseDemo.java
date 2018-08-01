package com.eab.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.demo.entity.Course;
import com.eab.demo.entity.Customer;
import com.eab.demo.entity.Instructor;
import com.eab.demo.entity.InstructorDetail;

public class CreateCourseDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			
			// get instructor from db
			int theId = 1; 
			// add courses to instructor
			Instructor instructor = session.get(Instructor.class, theId);
			// save course
			Course course1 = new Course("java");
			Course course2 = new Course("c");
			instructor.add(course1);
			instructor.add(course2);
			
			
			
			
			// save instructore
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
			System.out.println("done");
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
