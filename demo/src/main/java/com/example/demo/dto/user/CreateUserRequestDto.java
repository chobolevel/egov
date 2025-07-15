package com.example.demo.dto.user;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDto {
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	@NotEmpty
	private String nickname;
}
