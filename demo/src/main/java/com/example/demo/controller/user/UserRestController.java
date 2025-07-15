package com.example.demo.controller.user;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.common.PagingResponseDto;
import com.example.demo.dto.common.SuccessResponseDto;
import com.example.demo.dto.user.CreateUserRequestDto;
import com.example.demo.dto.user.GetUsersRequestDto;
import com.example.demo.dto.user.UserResponseDto;
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

	@GetMapping("/users")
	public ResponseEntity<?> getUsers(
			@RequestParam(required = false) String nickname,
			@RequestParam(required = false) String sortBy,
			@RequestParam(required = false) String sortDir,
			@RequestParam(required = false, defaultValue = "1") long page,
			@RequestParam(required = false, defaultValue = "10") long size
			) {
		GetUsersRequestDto request = GetUsersRequestDto.builder()
				.nickname(nickname)
				.sortBy(sortBy)
				.sortDir(sortDir)
				.page(page)
				.size(size)
				.build();
		PagingResponseDto<UserResponseDto> result = userService.getUsers(request);
		return ResponseEntity.ok(SuccessResponseDto.builder().data(result).build());
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUser(@PathVariable long id) {
		UserResponseDto result = userService.getUser(id);
		return ResponseEntity.ok(SuccessResponseDto.builder().data(result).build());
	}
	
}
