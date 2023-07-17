package com.bnym.gatepass.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.bnym.gatepass.models.Student;
import com.bnym.gatepass.service.LeaveRequestService;
import com.bnym.gatepass.service.UserService;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
	@InjectMocks
	StudentController studentController;

	@Mock
	UserService userService;

	@Mock
	LeaveRequestService leaveRequestService;

	@Test
	public void studentLoginTest1() {
		Student student = new Student();
		Mockito.when(userService.findByEmailIdAndPasswordHash("", "")).thenReturn(student);
		ResponseEntity<Object> res = studentController.studentLogin("", "");
		assertEquals(200, res.getStatusCodeValue());
	}

	@Test
	public void studentLoginTest2() {
		Mockito.when(userService.findByEmailIdAndPasswordHash("", "")).thenReturn(null);
		ResponseEntity<Object> res = studentController.studentLogin("", "");
		assertEquals(404, res.getStatusCodeValue());
	}

	@Test
	public void submitRequestFormTest1() {
		ResponseEntity<String> res = studentController.submitRequestForm(1, "2020-07-11", "2023-07-13", null);
	}

}