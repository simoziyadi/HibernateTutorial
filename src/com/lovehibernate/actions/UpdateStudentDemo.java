package com.lovehibernate.actions;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lovehibernate.entity.Student;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create the session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            Transaction tx = session.beginTransaction();

            Student myStudent = session.get(Student.class, studentId);

            myStudent.setFirstName("Scooby");

            session.getTransaction().commit();

            //New code going here
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email='simoziyadi@gmail.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done..!!!");


        } finally {
            factory.close();
        }

    }

}
