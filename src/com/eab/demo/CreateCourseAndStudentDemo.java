package com.eab.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.demo.entity.Course;
import com.eab.demo.entity.Instructor;
import com.eab.demo.entity.InstructorDetail;
import com.eab.demo.entity.Review;
import com.eab.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// begin transaction
			session.beginTransaction(); 
			
			// create a course
			Course course = new Course("c#");
			course.add(new Review("wow"));
			course.add(new Review("super"));
			course.add(new Review("nice..."));
			
			session.save(course);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
