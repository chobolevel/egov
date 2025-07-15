package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class DataNotFoundException extends RuntimeException {

	private HttpStatus status;
	
	public DataNotFoundException() {
		super("데이터를 찾을 수 없습니다.");
		this.status = HttpStatus.BAD_REQUEST;
	}
	
	public DataNotFoundException(String message) {
		super(message);
		this.status = HttpStatus.BAD_REQUEST;
	}
	
	public DataNotFoundException(String message, Throwable cause) {
		super(message, cause);
		this.status = HttpStatus.BAD_REQUEST;
	}
	
	public DataNotFoundException(String message, Throwable cause, HttpStatus status) {
		super(message, cause);
		this.status = status;
	}
	
}
