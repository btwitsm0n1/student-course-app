package com.studentcourse.test;

import com.studentcourse.entity.*;
import com.studentcourse.dao.HibernateUtil;
import org.hibernate.*;
import java.util.*;

public class ManyToManyTest {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s1 = new Student();
        s1.setName("Anu");

        Student s2 = new Student();
        s2.setName("Rahul");

        Course c1 = new Course();
        c1.setCourseName("Java");

        Course c2 = new Course();
        c2.setCourseName("Hibernate");

        List<Course> courseList = new ArrayList<>();
        courseList.add(c1);
        courseList.add(c2);

        s1.setCourses(courseList);
        s2.setCourses(courseList);

        session.save(s1);
        session.save(s2);

        tx.commit();
        session.close();

        System.out.println("Many-to-Many Records Inserted Successfully");
        HibernateUtil.shutdown();
    }
}