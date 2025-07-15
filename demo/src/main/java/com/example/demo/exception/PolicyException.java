package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class PolicyException extends RuntimeException {
	
	private final HttpStatus status;
	
	public PolicyException() {
		super("요청이 정책에서 정의한 조건을 만족하지 않습니다.");
		this.status = HttpStatus.BAD_REQUEST;
	}
	
	public PolicyException(String message) {
		super(message);
		this.status = HttpStatus.BAD_REQUEST;
	}
	
	public PolicyException(String message, Throwable cause) {
		super(message, cause);
		this.status = HttpStatus.BAD_REQUEST;
	}
	
	public PolicyException(String message, Throwable cause, HttpStatus status) {
		super(message, cause);
		this.status = status;
	}

}
