package com.example.studentManagement.controller;

import com.example.studentManagement.entity.Student;
import com.example.studentManagement.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("admission")
public class StudentController {

    @Autowired
    StudentServices studentServices;

    @PostMapping("/new")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student saveStudent = this.studentServices.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> student = this.studentServices.getAllStudent();
        return ResponseEntity.ok().body(student);
    }

    @GetMapping(value = "/find", params = "id")
    public ResponseEntity<Student> getStudentById(@RequestParam String id) {
        Student student = this.studentServices.getStudentById(id);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping(value = "/find", params = "email")
    public ResponseEntity<Student> getStudentByEmail(@RequestParam String email) {
        Student student = this.studentServices.getStudentByEmail(email);
        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        String student = this.studentServices.deleteStudent(id);
        return ResponseEntity.ok().body(student);
    }

    @PutMapping("update")
    public ResponseEntity updateStudent(@RequestBody Student student) {
        Student student1 = this.studentServices.updateStudent(student);
        return ResponseEntity.ok().body(student1);
    }

}
