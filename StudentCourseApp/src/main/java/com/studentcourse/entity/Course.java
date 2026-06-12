package com.studentcourse.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    // Getters and Setters
    public int getCid() { return cid; }
    public void setCid(int cid) { this.cid = cid; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}