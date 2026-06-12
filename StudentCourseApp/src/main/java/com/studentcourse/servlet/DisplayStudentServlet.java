package com.studentcourse.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.studentcourse.entity.Student;
import com.studentcourse.dao.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

@WebServlet("/DisplayStudentServlet")
public class DisplayStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        // ✅ Eager fetch courses using JOIN FETCH
        Query<Student> query = session.createQuery("FROM Student s JOIN FETCH s.courses", Student.class);
        List<Student> students = query.list();
        session.close();

        req.setAttribute("students", students);
        RequestDispatcher rd = req.getRequestDispatcher("displayStudent.jsp");
        rd.forward(req, res);
    }
}