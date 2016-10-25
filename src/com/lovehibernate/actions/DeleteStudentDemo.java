package com.lovehibernate.actions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lovehibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId=1;
			Transaction tx = session.beginTransaction();
			
			Student myStudent=session.get(Student.class, studentId);
			
			//session.delete(myStudent);
			session.createQuery("delete from Student s where s.id=2").executeUpdate();
						
			session.getTransaction().commit();
			
			
			System.out.println("Done..!!!");

			

		} finally {
			factory.close();
		}
	}

}
