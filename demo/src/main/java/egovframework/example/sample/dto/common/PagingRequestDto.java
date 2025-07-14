package egovframework.example.sample.dto.common;

import lombok.Setter;

@Setter
public class PagingRequestDto {
	private long page;
	private long size;
	
	public long getPage() {
		return (this.page - 1) * this.size;
	}
	public long getSize() {
		return this.size;
	}
}
