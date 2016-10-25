package com.lovehibernate.actions;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lovehibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//create the session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
				
				//create session
		Session session=factory.getCurrentSession();
		
		try{
		System.out.println("creating student object");
		Student tempStudent=new Student("Mohammed", "Zyadi", "medzyadi@gmail.com");
		
		Transaction tx= session.beginTransaction();
		
		//Saving the student
		System.out.println("saving student object");
		session.save(tempStudent);
		
		session.getTransaction().commit();
		System.out.println("Done...!!");
		}
		finally{
			factory.close();
		}

	}

}
