package com.example.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class SSNException {
	@ExceptionHandler(value = InvalidSSnException.class)
	public ResponseEntity<ApiError> handleNotSavingExcep() {
		//InvalidSSnException exception=new InvalidSSnException("not found ex");
		ApiError error=new ApiError(400,"not found ",new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<ApiError> handleNullSavingExcep() {
		//InvalidSSnException exception=new InvalidSSnException("not found ex");
		ApiError error=new ApiError(500,"null pointer ",new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_IMPLEMENTED);
		
	}

}
