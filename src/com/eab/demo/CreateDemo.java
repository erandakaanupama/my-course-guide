package com.eab.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eab.demo.entity.Student;
import com.eab.demo.entity.Instructor;
import com.eab.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			Instructor instructor = new Instructor("ins_fname", "ins_lname", "1@mail.com");
			InstructorDetail instructorDetail = new InstructorDetail("ins1_ytube", "cricket");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			// save instructore
			System.out.println("saving instructor" + instructor);
			session.save(instructor);
			
			session.getTransaction().commit();
			System.out.println("done");
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
