package com.example.demo.dto.user;

import java.util.List;

import javax.validation.constraints.Size;

import com.example.demo.constants.user.UserUpdateMask;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDto {
	private String nickname;
	@Size(min = 1)
	private List<UserUpdateMask> updateMask;
}
