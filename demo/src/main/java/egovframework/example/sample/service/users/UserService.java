package egovframework.example.sample.service.users;

import java.util.List;

import egovframework.example.sample.dto.users.CreateUserRequestDto;
import egovframework.example.sample.dto.users.GetUsersRequestDto;
import egovframework.example.sample.dto.users.UpdateUserRequestDto;
import egovframework.example.sample.dto.users.UserResponseDto;

public interface UserService {
	
	void save(CreateUserRequestDto request);
	
	UserResponseDto findById(long id);
	
	List<UserResponseDto> search(GetUsersRequestDto request);
	
	void modify(long id, UpdateUserRequestDto request);
	
	void delete(long id);

}
