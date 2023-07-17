package com.bnym.gatepass.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnym.gatepass.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    // Additional custom methods for Admin repository can be added here

//    Admin findByemail_id(String email_id);
	@Query(value = "SELECT * FROM admins ad WHERE ad.email_id = ?1 AND ad.password_hash = ?2 ", nativeQuery = true)
	Admin findByEmailIdAndPasswordHash(String emailId, String passwordHash);

	
	
}
