package com.example.demo.mapper.user;

import com.example.demo.entity.user.User;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("UserMapper")
public interface UserMapper {

	public void create(User user);
	
	public boolean existsByEmail(String email);
}
