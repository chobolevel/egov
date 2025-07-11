package egovframework.example.sample.service.users;

import egovframework.example.sample.dto.users.CreateUserRequestDto;
import egovframework.example.sample.dto.users.UpdateUserRequestDto;
import egovframework.example.sample.dto.users.UserResponseDto;

public interface UserService {
	
	void save(CreateUserRequestDto request);
	
	UserResponseDto findById(long id);
	
	void modify(long id, UpdateUserRequestDto request);

}
