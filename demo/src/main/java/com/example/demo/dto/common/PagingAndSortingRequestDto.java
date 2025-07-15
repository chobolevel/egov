package com.example.demo.dto.common;

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
public class PagingAndSortingRequestDto {
	private long page;
	private long size;
	private String sortBy;
	private String sortDir;
	
	public long getLimit() {
		return this.size;
	}
	public long getOffset() {
		return (this.page - 1) * this.size;
	}
}
