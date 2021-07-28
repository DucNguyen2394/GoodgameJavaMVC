package com.goodgame.api.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.goodgame.dto.UserDTO;
import com.goodgame.entity.UserEntity;
import com.goodgame.repository.UserRepository;
import com.goodgame.service.UserService;

@RestController
public class UserApi {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/api/user")
	public UserDTO createAccount(Model model,@RequestBody UserDTO userDTO,
			@Valid @ModelAttribute("form") UserEntity user, BindingResult errors) {
		
		if(errors.hasErrors()) {
			model.addAttribute("form",errors.getAllErrors());
			return null;
		}else {
			user = userRepository.findOneByUsername(userDTO.getUsername());
			
			if(user != null) {
				model.addAttribute("errors", "username is used");
				return null;
				
			}else {	
				return userService.save(userDTO);
			}
		}
	}
	
}
