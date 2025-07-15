package com.example.demo.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.common.ErrorResponseDto;
import com.example.demo.exception.PolicyException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PolicyException.class)
	public ResponseEntity<?> policyExceptionHandler(PolicyException e) {
		ErrorResponseDto errorResponse = ErrorResponseDto.builder()
				.status(e.getStatus())
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(e.getStatus()).body(errorResponse);
	}

}
