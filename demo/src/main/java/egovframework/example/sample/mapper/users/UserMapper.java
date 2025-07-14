package egovframework.example.sample.mapper.users;

import java.util.List;

import egovframework.example.sample.dto.users.GetUsersRequestDto;
import egovframework.example.sample.entity.User;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("UserMapper")
public interface UserMapper {

	void create(User user);
	
	User findById(long id);
	
	List<User> search(GetUsersRequestDto request);
	
	void modify(User user);
	
	void delete(long id);

}