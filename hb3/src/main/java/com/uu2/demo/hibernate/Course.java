package com.uu2.demo.hibernate;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="instructor_id")
    private String instructorid;

    public Course(){

    }
}
