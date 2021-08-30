package com.goodgame.api.admin.trash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.goodgame.service.UserService;

@RestController
public class TrashUserApi {
	
	@Autowired
	UserService userService;
	

}
