package com.example.studentManagement.services;

import com.example.studentManagement.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServices {
    Student saveStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentByEmail(String email);

    Student getStudentById(String Id);

    String deleteStudent(String studentId);

    Student updateStudent(Student student);
}
