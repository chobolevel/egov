package egovframework.example.sample.dto.common;

import lombok.Setter;

@Setter
public class PagingAndSortingRequestDto {
	private long page;
	private long size;
	
	private String sortBy;
	private String sortDir;
	
	public long getPage() {
		return (this.page - 1) * this.size;
	}
	public long getSize() {
		return this.size;
	}
	public String getSortBy() {
		return this.sortBy;
	}
	public String getSortDir() {
		return this.sortDir;
	}
}
