package com.example.demo.service.user.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.user.CreateUserRequestDto;
import com.example.demo.entity.user.User;

@Component
public class UserConverter {

	public User convert(CreateUserRequestDto request) {
		return User.builder()
				.email(request.getEmail())
				.password(request.getPassword())
				.nickname(request.getNickname())
				.isDeleted(false)
				.build();
	}
}
