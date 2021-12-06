package com.example.demo.model;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SsnAuthenticationFormModel {
	private String firstName;
	private String lastName;
	private String gender;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob;
	private String stateName;

}
