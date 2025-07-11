package egovframework.example.sample.service.users.impl;

import org.springframework.stereotype.Service;

import egovframework.example.sample.converter.UserConverter;
import egovframework.example.sample.dto.users.CreateUserRequestDto;
import egovframework.example.sample.dto.users.UserResponseDto;
import egovframework.example.sample.entity.User;
import egovframework.example.sample.mapper.users.UserMapper;
import egovframework.example.sample.service.users.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	
	private final UserConverter converter;

	@Override
	public void save(CreateUserRequestDto request) {
		User user = converter.convert(request);
		userMapper.save(user);
	}

	@Override
	public UserResponseDto findById(long id) {
		User user = userMapper.findById(id);
		UserResponseDto response = converter.convert(user);
		return response;
	}

}
