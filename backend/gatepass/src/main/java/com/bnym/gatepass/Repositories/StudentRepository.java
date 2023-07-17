package com.bnym.gatepass.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnym.gatepass.models.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

	@Query(value = "SELECT * FROM students ad WHERE ad.email_id = ?1 AND ad.password_hash = ?2 ", nativeQuery = true)
	Student findByEmailIdAndPasswordHash(String emailId, String passwordHash);
}

