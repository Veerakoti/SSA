package com.example.demo.service;

import java.util.List;

import com.example.demo.model.SsnAuthenticationFormModel;

public interface SsnService {
	public List<String> getAllStateNames();
	public String ssnEnrollment(SsnAuthenticationFormModel formModel);
	public String checkEnrollment(String ssn,String stateName);

}
