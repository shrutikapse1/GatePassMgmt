package com.bnym.gatepass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnym.gatepass.Repositories.StudentRepository;

@Service
public class UserService {
     @Autowired 
    private StudentRepository studentRepository;

}
