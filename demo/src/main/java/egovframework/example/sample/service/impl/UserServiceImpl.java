package egovframework.example.sample.service.impl;

import org.springframework.stereotype.Service;

import egovframework.example.sample.dto.CreateUserRequestDto;
import egovframework.example.sample.entity.User;
import egovframework.example.sample.mapper.UserMapper;
import egovframework.example.sample.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	@Override
	public void save(CreateUserRequestDto request) {
		User user = User.builder().email(request.getEmail()).password(request.getPassword())
				.nickname(request.getNickname()).build();
		userMapper.save(user);
	}

}
