package com.example.demo.exceptions;

import java.util.Date;

import lombok.Data;
@Data
public class ApiError {
	
	private Integer code;
	private String desc;
	private Date date;
	public ApiError(Integer code, String desc, Date date) {
		super();
		this.code = code;
		this.desc = desc;
		this.date = date;
	}
	

}
