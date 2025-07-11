package egovframework.example.sample.dto.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDto {
	private long id;
	private String nickname;
}
