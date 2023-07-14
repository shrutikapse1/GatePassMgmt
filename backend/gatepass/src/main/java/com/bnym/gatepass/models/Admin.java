package com.bnym.gatepass.models;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @Column(name = "email_id", nullable = false, unique = true) // Set username as unique and not null
    private String email_id;

    @Column(name = "adminFullName",nullable = false)
    private String adminFullName;

    @Column(name = "password_hash", nullable = false) // Set password as not null
    private String passwordHash;

    public Admin() {
    }

    public Admin(String email_id, String adminFullName, String passwordHash) {
        this.email_id = email_id;
        this.adminFullName = adminFullName;
        this.passwordHash = passwordHash;
    }

    // Getters and Setters

    public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
    
    public String getAdminFullName() {
        return adminFullName;
    }

	public void setAdminFullName(String adminFullName) {
        this.adminFullName = adminFullName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
