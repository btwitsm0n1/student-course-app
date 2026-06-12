<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Add Record</title></head>
<body>
    <h2>Add Student and Courses</h2>
    <form action="AddStudentCourseServlet" method="post">
        Student Name: <input type="text" name="studentName" required><br>
        Courses (comma separated): <input type="text" name="courseNames" placeholder="e.g., Java,Hibernate,Spring" size="50"><br>
        <input type="submit" value="Submit">
    </form>
    <a href="index.jsp">Back</a>
</body>
</html>