package com.bnym.gatepass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnym.gatepass.Repositories.StudentRepository;
import com.bnym.gatepass.models.Student;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student findByEmailIdAndPasswordHash(String emailId, String passwordHash) {
		return studentRepository.findByEmailIdAndPasswordHash(emailId, passwordHash);
	}

}
