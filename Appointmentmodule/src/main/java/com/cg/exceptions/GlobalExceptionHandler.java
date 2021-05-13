package com.cg.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> globalExceptionHandler(Exception ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails();
		return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AppointmentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resourceNotFoundException(AppointmentNotFoundException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails();
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}

}
