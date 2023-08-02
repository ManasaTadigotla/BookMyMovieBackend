package com.mymovie.ExceptionHandler;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementExcep)
	{
		return new ResponseEntity<String>("Requested element is not found in the DB", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException methodNotAllowedException)
	{
		return new ResponseEntity<Object>("http method type is mismatched", HttpStatus.METHOD_NOT_ALLOWED);
		
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException)
	{
		return new ResponseEntity<Object>("Please provide valid input", HttpStatus.BAD_REQUEST);
		
	}
}
