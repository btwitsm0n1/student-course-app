package com.studentcourse.servlet;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentcourse.entity.*;
import com.studentcourse.dao.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@WebServlet("/AddStudentCourseServlet")
public class AddStudentCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        String studentName = req.getParameter("studentName");
        String courseNamesStr = req.getParameter("courseNames");
        String[] courseNameArray = courseNamesStr.split(",");
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        Student student = new Student();
        student.setName(studentName);
        
        List<Course> courses = new ArrayList<>();
        for (String cn : courseNameArray) {
            String courseName = cn.trim();
            Query<Course> q = session.createQuery("FROM Course WHERE courseName = :cname", Course.class);
            q.setParameter("cname", courseName);
            Course course = q.uniqueResult();
            if (course == null) {
                course = new Course();
                course.setCourseName(courseName);
            }
            courses.add(course);
        }
        
        student.setCourses(courses);
        session.save(student);
        
        tx.commit();
        session.close();
        
        res.setContentType("text/html");
        res.getWriter().println("<h3 style='color:green'>Record added successfully!</h3>");
        res.getWriter().println("<a href='index.jsp'>Go Home</a>");
    }
}