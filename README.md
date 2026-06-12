# Student Course Management System

A web-based application to demonstrate **Many-to-Many** relationship between Student and Course using **Hibernate**, **JSP**, **Servlets**, and **MySQL**.



## 📌 Project Overview

This project allows users to:
- Add students and assign multiple courses to them.
- View all students along with their enrolled courses.
- View all courses along with the list of students enrolled in them.

The relationship between Student and Course is **Many-to-Many** (one student can enroll in many courses, and one course can have many students).



## 🛠️ Technologies Used

- Java (JSP, Servlets)
- Hibernate 5 (ORM)
- MySQL 8
- Apache Tomcat 9
- JSTL
- HTML/CSS


## 🚀 How to Run

### Prerequisites

- Eclipse IDE for Enterprise Java
- Apache Tomcat 9
- MySQL
- Maven

### Steps

 Clone the repository:
   
   git clone https://github.com/your-username/StudentCourseApp.git

Import as Existing Maven Project in Eclipse.

Update Maven dependencies.

Create MySQL database:

CREATE DATABASE hibdb;

Update hibernate.cfg.xml with your MySQL username/password.

Deploy on Tomcat 9 and run.

Access URLs
Home: http://localhost:8080/StudentCourseApp/index.jsp

Add Student & Course: addRecord.jsp

Show All Students: DisplayStudentServlet

Show All Courses: DisplayCourseServlet

📝 Author
Moni Shankar
PG-DAC, CDAC Noida

📅 Submitted To
PG-DAC Faculty



