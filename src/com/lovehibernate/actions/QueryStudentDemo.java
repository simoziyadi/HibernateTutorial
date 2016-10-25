package com.lovehibernate.actions;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lovehibernate.entity.Student;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // create the session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            long startTime = System.nanoTime();
            Transaction tx = session.beginTransaction();

            // Select all students
            // List<Student> lst = session.createQuery("FROM Student").list();
            // Select all the students with last name Doe
            /*
			 * List<Student> lst = session.createQuery(
			 * "FROM Student s where s.lastName='Doa'" +
			 * "OR s.firstName='Duffy'").list();
			 */
            List<Student> lst = session.createQuery("FROM Student s where s.email like '%@hotmail.com'").list();

            System.out.println("Done...!!");
            session.getTransaction().commit();
            long storpTime = System.nanoTime();
            System.out.println("time made is: ==" + (storpTime - startTime));

            displayStudents(lst);

        } finally {
            factory.close();
        }

    }

    // Display the students
    private static void displayStudents(List<Student> lst) {
        for (Student student : lst) {
            System.out.println(student);

        }
    }

}
