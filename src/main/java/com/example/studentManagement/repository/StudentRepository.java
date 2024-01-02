package com.example.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentManagement.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findByEmail(String email);
}
