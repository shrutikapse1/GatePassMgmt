package com.bnym.gatepass.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnym.gatepass.models.Student;
import com.bnym.gatepass.service.LeaveRequestService;
import com.bnym.gatepass.service.UserService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	UserService userService;

	@Autowired
	LeaveRequestService leaveRequestService;

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

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ResponseEntity<String> submitRequestForm(@RequestParam("studentid") int studentId,
			@RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			@RequestParam("reason") String reason) {
		LocalDate createdAt = LocalDate.now();
		int status = leaveRequestService.submitRequestForm(studentId, startDate, endDate, reason, "PENDING",createdAt);
		if (status > 0) {
			return ResponseEntity.ok("Successfull");

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid");

		}
	}
	
	
	
	

}