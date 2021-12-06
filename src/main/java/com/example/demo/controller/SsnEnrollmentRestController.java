package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SsnAuthenticationFormModel;
import com.example.demo.service.SsnService;

@RestController
public class SsnEnrollmentRestController {
	@Autowired
	private SsnService service;
	@PostMapping(value = "/enrollSsn",consumes = "application/json")
	public ResponseEntity<String> enrollSsn(@RequestBody SsnAuthenticationFormModel request){
		ResponseEntity<String> response=null;
		String ssnEnrollment = service.ssnEnrollment(request);
		String body="Your Enrollment of SSn Complete . Your SSN :: "+ssnEnrollment;
		response=new ResponseEntity<>(body, HttpStatus.CREATED);
		return response;
	}

}
