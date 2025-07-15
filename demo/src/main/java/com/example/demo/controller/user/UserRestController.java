package com.example.demo.controller.user;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.common.SuccessResponseDto;
import com.example.demo.dto.user.CreateUserRequestDto;
import com.example.demo.service.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserRestController {
	
	private final UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<?> create(@Valid @RequestBody CreateUserRequestDto request) {
		userService.create(request);
		return ResponseEntity.ok(SuccessResponseDto.builder().data(true).build());
	}

}
