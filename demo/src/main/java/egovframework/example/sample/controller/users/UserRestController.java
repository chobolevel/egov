package egovframework.example.sample.controller.users;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.sample.dto.common.ResultResponseDto;
import egovframework.example.sample.dto.users.CreateUserRequestDto;
import egovframework.example.sample.dto.users.GetUsersRequestDto;
import egovframework.example.sample.dto.users.UpdateUserRequestDto;
import egovframework.example.sample.dto.users.UserResponseDto;
import egovframework.example.sample.service.users.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserRestController {

	private final UserService userService;

	@PostMapping("/users")
	public ResponseEntity<?> save(@RequestBody CreateUserRequestDto request) {
		userService.save(request);
		return ResponseEntity.ok(ResultResponseDto.builder().data(true).build());
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUser(@PathVariable long id) {
		UserResponseDto response = userService.findById(id);
		return ResponseEntity.ok(ResultResponseDto.builder().data(response).build());
	}

	@GetMapping("/users")
	public ResponseEntity<?> getUsers(
			@RequestParam(required = false, defaultValue = "1") long page,
			@RequestParam(required = false, defaultValue = "10") long size,
			@RequestParam(required = false) String sortBy,
			@RequestParam(required = false) String sortDir) {
		GetUsersRequestDto request = new GetUsersRequestDto();
		request.setPage(page);
		request.setSize(size);
		request.setSortBy(sortBy);
		request.setSortDir(sortDir);
		List<UserResponseDto> userResponses = userService.search(request);
		return ResponseEntity.ok(ResultResponseDto.builder().data(userResponses).build());
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<?> modify(@PathVariable long id, @RequestBody UpdateUserRequestDto request) {
		userService.modify(id, request);
		return ResponseEntity.ok(ResultResponseDto.builder().data(true).build());
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		userService.delete(id);
		return ResponseEntity.ok(ResultResponseDto.builder().data(true).build());
	}

}
