package egovframework.example.sample.updater.users;

import org.springframework.stereotype.Component;

import egovframework.example.sample.dto.users.UpdateUserRequestDto;
import egovframework.example.sample.entity.User;

@Component
public class UserUpdater {
	
	public User markAsUpdate(UpdateUserRequestDto request, User user) {
		user.setNickname(request.getNickname());
		return user;
	}

}
