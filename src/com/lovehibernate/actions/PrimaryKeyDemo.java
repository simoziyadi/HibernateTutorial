package com.lovehibernate.actions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lovehibernate.entity.Student;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        //create the session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            System.out.println("creating student object");
            Student tempStudent1 = new Student("Jhon", "Doa", "Jhon@gmail.com");
            Student tempStudent2 = new Student("Paul", "Aplebaum", "Paul@gmail.com");
            Student tempStudent3 = new Student("Marry", "Public", "Marry@gmail.com");


            Transaction tx = session.beginTransaction();

            //Saving 3 student objects
            System.out.println("saving student object");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();
            System.out.println("Done...!!");
        } finally {
            factory.close();
        }
    }

}
