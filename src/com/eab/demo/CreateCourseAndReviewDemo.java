package com.eab.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.demo.entity.Course;
import com.eab.demo.entity.Instructor;
import com.eab.demo.entity.InstructorDetail;
import com.eab.demo.entity.Review;
import com.eab.demo.entity.Student;

public class CreateCourseAndReviewDemo {

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
			Course course = new Course("PYTHON2");	
			session.save(course);
			
			// create students
			Student student = new Student("eab", "bandara", "mail.com");
			
			// add students to course
			course.addStudent(student);
			
			// save student
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
