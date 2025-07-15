package com.example.demo.service.user.validator;

import org.springframework.stereotype.Component;

import com.example.demo.dto.user.CreateUserRequestDto;
import com.example.demo.exception.PolicyException;
import com.example.demo.mapper.user.UserMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserValidator {
	
	private final UserMapper userMapper;

	public void validate(CreateUserRequestDto request) {
		if(userMapper.existsByEmail(request.getEmail())) {
			throw new PolicyException("이미 존재하는 이메일입니다.");
		}
	}
}
