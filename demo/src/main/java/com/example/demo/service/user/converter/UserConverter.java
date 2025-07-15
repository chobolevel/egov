package com.example.demo.service.user.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.user.CreateUserRequestDto;
import com.example.demo.dto.user.UserResponseDto;
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
	
	public UserResponseDto convert(User user) {
		return UserResponseDto.builder()
				.id(user.getId())
				.email(user.getEmail())
				.nickname(user.getNickname())
				.createdAt(user.getCreatedAt().toString())
				.updatedAt(user.getUpdatedAt().toString())
				.build();
	}
	
	public List<UserResponseDto> convert(List<User> users) {
		return users.stream().map(this::convert).collect(Collectors.toList());
	}
}
