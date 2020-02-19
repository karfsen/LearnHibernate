package com.uu2.demo;

import com.uu2.demo.hibernate.Course;
import com.uu2.demo.hibernate.Instructor;
import com.uu2.demo.hibernate.InstructorDetail;
import com.uu2.demo.hibernate.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesAndReviews {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 10;
            Course tempCourse = (Course) session.get(Course.class, theId);

            System.out.println("deleting course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.delete(tempCourse);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
