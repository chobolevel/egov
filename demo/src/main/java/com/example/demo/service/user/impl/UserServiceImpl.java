package com.example.demo.service.user.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.user.CreateUserRequestDto;
import com.example.demo.entity.user.User;
import com.example.demo.mapper.user.UserMapper;
import com.example.demo.service.user.UserService;
import com.example.demo.service.user.converter.UserConverter;
import com.example.demo.service.user.validator.UserValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserMapper userMapper;
	
	private final UserConverter userConverter;
	
	private final UserValidator userValidator;

	@Override
	public void create(CreateUserRequestDto request) {
		userValidator.validate(request);
		User user = userConverter.convert(request);
		userMapper.create(user);
	}

}
