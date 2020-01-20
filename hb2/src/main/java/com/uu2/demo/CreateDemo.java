package com.uu2.demo;

import com.uu2.demo.hibernate.InstructorDetail;
import com.uu2.demo.hibernate.Instructor;
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
            Instructor tempInstructor = new Instructor("Martin ","Karfa","skap@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/wtf","wtf");
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();
            System.out.println("Commit transaction");
            session.getTransaction().commit();
            System.out.println("Done");
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            factory.close();
        }
    }

}

