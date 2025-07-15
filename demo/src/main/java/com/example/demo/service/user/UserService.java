package com.example.demo.service.user;

import com.example.demo.dto.common.PagingResponseDto;
import com.example.demo.dto.user.CreateUserRequestDto;
import com.example.demo.dto.user.GetUsersRequestDto;
import com.example.demo.dto.user.UpdateUserRequestDto;
import com.example.demo.dto.user.UserResponseDto;

public interface UserService {

	public void create(CreateUserRequestDto request);
	
	public PagingResponseDto<UserResponseDto> getUsers(GetUsersRequestDto request);
	
	public UserResponseDto getUser(long id);
	
	public void modify(long id, UpdateUserRequestDto request);
}
