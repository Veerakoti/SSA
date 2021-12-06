package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SsnService;

@RestController
public class SsnValidateRestController {
	@Autowired
	private SsnService service;
	@GetMapping(value = "/validateSsn/{ssn}/{state}")
	public ResponseEntity<String> validateSsn(@PathVariable("ssn") String ssn,@PathVariable("state") String state){
		ResponseEntity<String> response=null;
		String checkEnrollment = service.checkEnrollment(ssn, state);
		response=new ResponseEntity<>(checkEnrollment, HttpStatus.OK);
		
		return response;
	}

}
