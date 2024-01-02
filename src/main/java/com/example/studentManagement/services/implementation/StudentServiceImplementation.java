package com.example.studentManagement.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import com.example.studentManagement.entity.Student;
import com.example.studentManagement.repository.StudentRepository;
import com.example.studentManagement.services.StudentServices;

import com.example.studentManagement.exception.ResourceNotFoundException;

@Service
public class StudentServiceImplementation implements StudentServices {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        student.setPassword(passwordEncryption(student.getPassword()));
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentByEmail(String email) {
        return this.studentRepository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Given email Id does not exists"));
    }

    @Override
    public Student getStudentById(String id) {
        return this.studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Given Student Id not exists "));
    }

    @Override
    public String deleteStudent(String studentId) {

        this.studentRepository.deleteById(studentId);
        return "Student with id " + studentId + " has been deleted";
    }

    @Override
    public Student updateStudent(Student student) {
        Student existedStudent = getStudentById(student.getId());

        existedStudent.setEmail(student.getEmail());
        existedStudent.setFirstName(student.getFirstName());
        existedStudent.setMiddleName(student.getMiddleName());
        existedStudent.setLastName(student.getLastName());
        existedStudent.setSection(student.getSection());
        existedStudent.setSession(student.getSession());
        existedStudent.setStd(student.getStd());

        return this.studentRepository.save(student);
    }

    public String passwordEncryption(String password) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
