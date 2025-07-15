package com.example.demo.entity.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private long id;
	private String email;
	private String password;
	private String nickname;
	private boolean isDeleted;
	private LocalDate createdAt;
	private LocalDate updatedAt;
}
