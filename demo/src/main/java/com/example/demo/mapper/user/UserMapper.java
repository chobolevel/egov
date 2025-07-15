package com.example.demo.mapper.user;

import java.util.List;

import com.example.demo.dto.user.GetUsersRequestDto;
import com.example.demo.entity.user.User;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("UserMapper")
public interface UserMapper {

	public void create(User user);
	
	public boolean existsByEmail(String email);
	
	public List<User> getUsers(GetUsersRequestDto request);
	
	public User getUser(long id);
	
	public void modify(User user);
	
	public long getCount(GetUsersRequestDto request);
	
	public void remove(long id);
}
