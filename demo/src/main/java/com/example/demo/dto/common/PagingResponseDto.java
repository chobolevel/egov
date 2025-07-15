package com.example.demo.dto.common;

import java.util.List;

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
public class PagingResponseDto<T> {
	private long page;
	private long size;
	private List<T> data;
	private long totalCount;
}
