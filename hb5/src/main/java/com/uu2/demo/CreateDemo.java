package com.uu2.demo;


import com.uu2.demo.hibernate.Instructor;
import com.uu2.demo.hibernate.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor tempInstruction = new Instructor("Mim", "Varg", "mim@gmail.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("youtubeMim", "drawing");

            tempInstruction.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("saving instructor: " + tempInstruction);
            session.save(tempInstruction);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}