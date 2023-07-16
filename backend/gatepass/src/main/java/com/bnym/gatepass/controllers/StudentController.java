package com.bnym.gatepass.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnym.gatepass.models.Student;
import com.bnym.gatepass.service.UserService;

@RestController
public class StudentController {
	@Autowired
	private UserService userService;




}
