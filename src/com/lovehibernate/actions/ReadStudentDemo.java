package com.lovehibernate.actions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lovehibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		//create the session factory
				SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
						
						//create session
				Session session=factory.getCurrentSession();
				
				try{
				System.out.println("creating student object");
				Student tempStudent=new Student("Duffy", "Duck", "duffy@gmail.com");
				
				Transaction tx= session.beginTransaction();
				
				//Saving the student
				System.out.println("saving student object");
				System.out.println(tempStudent);
				session.save(tempStudent);
				
				session.getTransaction().commit();
				System.out.println("tempStudent generated Id:"+tempStudent.getId());
				
				//now get a new session and start a new Transaction
				session=factory.getCurrentSession();
				session.beginTransaction();
				//retrieve the student based on the student id
				System.out.println("\n getting the student with id:"+tempStudent.getId());

				Student mystudent=session.get(Student.class, tempStudent.getId());
				session.getTransaction().commit();
				System.out.println("Get complete... :"+mystudent);

				System.out.println("Done...!!");
				
				}
				finally{
					factory.close();
				}
	}

}
