package com.bnym.gatepass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnym.gatepass.models.Student;
import com.bnym.gatepass.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<Object> studentLogin(@RequestParam("email_id") String emailId,
			@RequestParam("password_hash") String passwordHash) {
		Student student = userService.findByEmailIdAndPasswordHash(emailId, passwordHash);
		if (student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid username or password");
		} else {
			return ResponseEntity.ok(student);
		}
	}

}