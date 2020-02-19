package com.uu2.demo;

import com.uu2.demo.hibernate.Course;
import com.uu2.demo.hibernate.Instructor;
import com.uu2.demo.hibernate.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int theId = 1;
            Instructor tempInstructor = (Instructor) session.get(Instructor.class, theId);
            Course course1 = new Course("learn nodejs");
            Course course2 = new Course("learn java");
            tempInstructor.add(course1);
            tempInstructor.add(course2);
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}