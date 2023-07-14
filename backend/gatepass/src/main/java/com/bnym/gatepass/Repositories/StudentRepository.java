package com.bnym.gatepass.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnym.gatepass.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Additional custom methods for Student repository can be added here
}
