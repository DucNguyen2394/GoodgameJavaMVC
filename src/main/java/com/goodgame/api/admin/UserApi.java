package com.goodgame.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodgame.dto.UserDTO;
import com.goodgame.service.UserService;

@RestController
public class UserApi {

	@Autowired
	UserService userService;
	
	@PostMapping("api/user")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {	
		return userService.save(userDTO);
	}
	
	@PutMapping("api/user")
	public UserDTO editUser(@RequestBody UserDTO userDTO) {		
		return userService.save(userDTO);
	}
	
	@DeleteMapping("api/user")
	public void deleteUser(@RequestBody long[] ids) {
		userService.delete(ids);
	}
}
