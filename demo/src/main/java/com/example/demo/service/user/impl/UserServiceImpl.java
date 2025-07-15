package com.example.demo.service.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.common.PagingResponseDto;
import com.example.demo.dto.user.CreateUserRequestDto;
import com.example.demo.dto.user.GetUsersRequestDto;
import com.example.demo.dto.user.UpdateUserRequestDto;
import com.example.demo.dto.user.UserResponseDto;
import com.example.demo.entity.user.User;
import com.example.demo.exception.DataNotFoundException;
import com.example.demo.mapper.user.UserMapper;
import com.example.demo.service.user.UserService;
import com.example.demo.service.user.converter.UserConverter;
import com.example.demo.service.user.updater.UserUpdater;
import com.example.demo.service.user.validator.UserValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	private final UserConverter userConverter;

	private final UserValidator userValidator;
	
	private final UserUpdater userUpdater;

	@Override
	public void create(CreateUserRequestDto request) {
		userValidator.validate(request);
		User user = userConverter.convert(request);
		userMapper.create(user);
	}

	@Override
	public PagingResponseDto<UserResponseDto> getUsers(GetUsersRequestDto request) {
		List<User> users = userMapper.getUsers(request);
		List<UserResponseDto> responses = userConverter.convert(users);
		long totalCount = userMapper.getCount(request);
		PagingResponseDto<UserResponseDto> response = new PagingResponseDto<UserResponseDto>(request.getPage(),
				request.getSize(), responses, totalCount);
		return response;
	}

	@Override
	public UserResponseDto getUser(long id) {
		User user = userMapper.getUser(id);
		if(user == null) {
			throw new DataNotFoundException("회원을 찾을 수 없습니다.");
		}
		return userConverter.convert(user);
	}

	@Override
	public void modify(long id, UpdateUserRequestDto request) {
		User foundUser = userMapper.getUser(id);
//		User userForModify = userUpdater.markAsUpdate(request, foundUser);
		foundUser.setNickname(request.getNickname());
		userMapper.modify(foundUser);
	}

}
