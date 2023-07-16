package com.bnym.gatepass.models;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "studentid",unique = true,nullable = false)
    private int studentID;

    @Column(name = "student_full_name",nullable = false)
    private String studentFullName;

    @Column(name = "class",nullable = false)
    private String className;

    @Column(name = "division",nullable = false)
    private String division;

    @Column(name = "roll_no",nullable = false)
    private String rollNo;

    @Column(name = "email_id", nullable = false, unique = true) // Set username as unique and not null
    private String email_id;

    @Column(name = "password_hash", nullable = false) // Set password as unique and not null
    private String passwordHash;

    public Student() {

    }

    public Student(int studentID, String studentFullName, String className, String division, String rollNo,
                   String email_id, String passwordHash) {
        super();
        this.studentID = studentID;
        this.studentFullName = studentFullName;
        this.className = className;
        this.division = division;
        this.rollNo = rollNo;
        this.email_id = email_id;
        this.passwordHash = passwordHash;
    }

    // Getters and Setters

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
