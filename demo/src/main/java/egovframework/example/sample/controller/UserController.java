package egovframework.example.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import egovframework.example.sample.dto.CreateUserRequestDto;
import egovframework.example.sample.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/users.do")
	public String save(CreateUserRequestDto request) {
		userService.save(request);
		return "redirect:/";
	}

}
