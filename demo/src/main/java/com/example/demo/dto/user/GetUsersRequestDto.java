package com.example.demo.dto.user;

import com.example.demo.dto.common.PagingAndSortingRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GetUsersRequestDto extends PagingAndSortingRequestDto {
	private String nickname;
}
