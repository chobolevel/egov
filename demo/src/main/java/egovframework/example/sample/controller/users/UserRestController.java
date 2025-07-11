package egovframework.example.sample.controller.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.sample.dto.users.CreateUserRequestDto;
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
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUser(@PathVariable long id) {
		UserResponseDto response = userService.findById(id);
		return ResponseEntity.ok(response);
	}

}
