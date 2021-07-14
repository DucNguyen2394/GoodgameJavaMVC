package com.goodgame.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodgame.dto.UserDTO;
import com.goodgame.service.UserService;

@RestController
public class UserApi {

	@Autowired
	UserService userService;
	
	@PostMapping("/api/user")
	public UserDTO createAccount(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
}
