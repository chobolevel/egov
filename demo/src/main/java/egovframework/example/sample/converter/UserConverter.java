package egovframework.example.sample.converter;

import org.springframework.stereotype.Component;

import egovframework.example.sample.dto.users.CreateUserRequestDto;
import egovframework.example.sample.dto.users.UserResponseDto;
import egovframework.example.sample.entity.User;

@Component
public class UserConverter {
	
	public User convert(CreateUserRequestDto request) {
		return User.builder()
				.email(request.getEmail())
				.password(request.getPassword())
				.nickname(request.getNickname())
				.isDeleted(false)
				.build();
	}
	
	public UserResponseDto convert(User user) {
		return UserResponseDto.builder()
				.id(user.getId())
				.email(user.getEmail())
				.nickname(user.getNickname())
				.createdAt(user.getCreatedAt().toInstant().toEpochMilli())
				.updatedAt(user.getUpdatedAt().toInstant().toEpochMilli())
				.build();
	}

}
