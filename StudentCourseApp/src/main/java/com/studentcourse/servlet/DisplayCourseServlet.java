package com.studentcourse.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.studentcourse.entity.Course;
import com.studentcourse.dao.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

@WebServlet("/DisplayCourseServlet")
public class DisplayCourseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        // ✅ Eager fetch students for each course
        Query<Course> query = session.createQuery("FROM Course c JOIN FETCH c.students", Course.class);
        List<Course> courses = query.list();
        session.close();

        req.setAttribute("courses", courses);
        RequestDispatcher rd = req.getRequestDispatcher("displayCourse.jsp");
        rd.forward(req, res);
    }
}