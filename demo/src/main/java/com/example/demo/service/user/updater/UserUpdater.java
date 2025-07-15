package com.example.demo.service.user.updater;

import org.springframework.stereotype.Component;

import com.example.demo.constants.user.UserUpdateMask;
import com.example.demo.dto.user.UpdateUserRequestDto;
import com.example.demo.entity.user.User;

@Component
public class UserUpdater {

	public User markAsUpdate(UpdateUserRequestDto request, User user) {
		for(UserUpdateMask updateMask : request.getUpdateMask()) {
			switch(updateMask) {
				case NICKNAME:
					if(request.getNickname() != null) {
						user.setNickname(request.getNickname());
					}
					break;
				default:
					break;
			}
		}
		return user;
	}

}
