package com.bnym.gatepass.service;

import com.bnym.gatepass.models.Student;

public interface UserService {

	public Student findByEmailIdAndPasswordHash(String emailId, String passwordHash);
}
