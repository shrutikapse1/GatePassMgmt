package com.bnym.gatepass.models;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @Column(name = "email_id", nullable = false, unique = true) // Set username as unique and not null
    private String email_id;

    @Column(name = "admin_full_name",nullable = false)
    private String admin_full_name;

    @Column(name = "password_hash", nullable = false) // Set password as not null
    private String passwordHash;

    public Admin() {
    }

    public Admin(String email_id, String admin_full_name, String passwordHash) {
        this.email_id = email_id;
        this.admin_full_name = admin_full_name;
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
        return admin_full_name;
    }

	public void setAdminFullName(String admin_full_name) {
        this.admin_full_name = admin_full_name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
