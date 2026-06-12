<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Student List</title></head>
<body>
    <h2>All Students with their Courses</h2>
    <table border="1">
        <tr><th>Student ID</th><th>Student Name</th><th>Courses Enrolled</th></table>
        <c:forEach var="stu" items="${students}">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>
                    <c:forEach var="crs" items="${stu.courses}">
                        ${crs.courseName}<br>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="index.jsp">Back</a>
</body>
</html>