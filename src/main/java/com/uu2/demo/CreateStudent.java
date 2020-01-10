package com.uu2.demo;

import com.uu2.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class CreateStudent {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try {
            System.out.println("Connecting");
            Student student=new Student("Paul","Walker","skap@gmail.com");
            Student student2=new Student("Tomaš","Varga","haha@haha.com");
            Student student3=new Student("Lukaš","Pastorek","wtf@post.sk");
            session.beginTransaction();
            session.save(student);
            session.save(student2);
            session.save(student3);
            session.get(Student.class,student.getId());
            session.getTransaction().commit();
            System.out.println(student.getId());

            //getting student by id
            session=factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("getting student with id: "+ student3.getId());
            Student studentFromDB=session.get(Student.class,student3.getId());
            System.out.println("Get complete "+studentFromDB);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }
}
