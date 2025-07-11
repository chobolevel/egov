package egovframework.example.sample.mapper.users;

import egovframework.example.sample.entity.User;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("UserMapper")
public interface UserMapper {

	void save(User user);
	
	User findById(long id);

}