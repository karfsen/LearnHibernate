package com.uu2.demo;

import com.uu2.demo.hibernate.Course;
import com.uu2.demo.hibernate.Instructor;
import com.uu2.demo.hibernate.InstructorDetail;
import com.uu2.demo.hibernate.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviews {

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

            Course tempCourse = new Course("novy kurz");
            tempCourse.addReview(new Review("Super kurz to bol"));
            tempCourse.addReview(new Review("Uzasne"));
            tempCourse.addReview(new Review("No neviem neviem"));

            System.out.println("saving the course : " + tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
