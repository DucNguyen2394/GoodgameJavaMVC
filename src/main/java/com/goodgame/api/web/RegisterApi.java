package com.goodgame.api.web;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import com.goodgame.dto.UserDTO;
import com.goodgame.entity.UserEntity;
import com.goodgame.repository.UserRepository;
import com.goodgame.service.UserService;

@RestController
public class RegisterApi {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
//	@PostMapping("/api/register")
//	public RedirectView createAccount(Model model,
//			UserEntity user,
//			@RequestBody @Validated UserDTO userDTO,
//			BindingResult result) throws IOException 
//	{
//		
//		if(result.hasErrors()) {
//			model.addAttribute("errors", result.getAllErrors());
//			
//			RedirectView rv = new RedirectView("http://localhost:8080/goodgame/account/register");
//			rv.setStatusCode(HttpStatus.BAD_REQUEST);
//			return rv;
//		}else if(!(userDTO.getPassword().equals(userDTO.getConfirmPassword()))) {
//			RedirectView rv = new RedirectView("http://localhost:8080/goodgame/account/register");
//			rv.setStatusCode(HttpStatus.BAD_REQUEST);
//			return rv;
//		}
//		user = userRepository.findOneByUsername(userDTO.getUsername());
//			
//			if(user != null) {	
//				RedirectView rv = new RedirectView("http://localhost:8080/goodgame/account/register");
//				rv.setStatusCode(HttpStatus.BAD_REQUEST);
//				return rv;			
//			}else {	
//
//				userService.save(userDTO);	
//				RedirectView rv = new RedirectView("http://localhost:8080/goodgame/login");
//		        rv.setStatusCode(HttpStatus.OK);
//
//		        return rv;
//			}
//		}
	
	@PostMapping("/api/register")
	public UserDTO createAcount(
			@RequestBody @Valid UserDTO userDTO,
			UserEntity user,
			BindingResult result,
			Model model) 
	{
		if(result.hasErrors()) {
			model.addAttribute("error", result.getAllErrors());
		}
		user = userRepository.findOneByUsername(userDTO.getUsername());
		if(user != null) {
			model.addAttribute("error", "invalid!!!");
			return null;
		}
		return userService.create(userDTO);
	}
}
	

