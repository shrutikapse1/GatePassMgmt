package com.bnym.gatepass.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnym.gatepass.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    // Additional custom methods for Admin repository can be added here
}
