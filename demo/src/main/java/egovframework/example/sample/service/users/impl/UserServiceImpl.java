package egovframework.example.sample.service.users.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.example.sample.converter.UserConverter;
import egovframework.example.sample.dto.users.CreateUserRequestDto;
import egovframework.example.sample.dto.users.GetUsersRequestDto;
import egovframework.example.sample.dto.users.UpdateUserRequestDto;
import egovframework.example.sample.dto.users.UserResponseDto;
import egovframework.example.sample.entity.User;
import egovframework.example.sample.mapper.users.UserMapper;
import egovframework.example.sample.service.users.UserService;
import egovframework.example.sample.updater.users.UserUpdater;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	
	private final UserConverter converter;
	
	private final UserUpdater updater;

	@Override
	public void save(CreateUserRequestDto request) {
		User user = converter.convert(request);
		userMapper.create(user);
	}

	@Override
	public UserResponseDto findById(long id) {
		User user = userMapper.findById(id);
		UserResponseDto response = converter.convert(user);
		return response;
	}
	
	@Override
	public List<UserResponseDto> search(GetUsersRequestDto request) {
		List<User> users = userMapper.search(request);
		for(User user : users) {
			System.out.println(user.getId());
		}
		return converter.convert(users);
	}

	@Override
	public void modify(long id, UpdateUserRequestDto request) {
		User user = userMapper.findById(id);
		User updatedUser = updater.markAsUpdate(request, user);
		userMapper.modify(updatedUser);
	}

	@Override
	public void delete(long id) {
		userMapper.delete(id);
	}

}
