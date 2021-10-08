package com.goodgame.api.admin.trash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodgame.dto.UserDTO;
import com.goodgame.service.UserService;

@RestController
public class TrashUserApi {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/user/trash")
	public UserDTO restoreUser(@RequestBody long[] ids) {
		return userService.restore(ids);
	}
	
	@DeleteMapping("api/user/trash")
	public void deleteUser(@RequestBody long[] ids) {
		userService.deleteTrash(ids);
	}
}
