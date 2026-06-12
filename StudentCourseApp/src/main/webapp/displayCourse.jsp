<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Course List</title></head>
<body>
    <h2>All Courses with Enrolled Students</h2>
    <table border="1">
        <tr><th>Course ID</th><th>Course Name</th><th>Enrolled Students</th></tr>
        <c:forEach var="crs" items="${courses}">
            <tr>
                <td>${crs.cid}</td>
                <td>${crs.courseName}</td>
                <td>
                    <c:forEach var="stu" items="${crs.students}">
                        ${stu.name}<br>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="index.jsp">Back</a>
</body>
</html>