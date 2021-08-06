package com.goodgame.api.web;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
public class UserApi {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/api/user")
	public RedirectView createAccount(Model model,UserEntity user,
			@RequestBody @Validated UserDTO userDTO,BindingResult result,HttpServletResponse response) throws IOException {
		
		if(result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			
			RedirectView rv = new RedirectView("http://localhost:8080/goodgame/account/register");
			rv.setStatusCode(HttpStatus.BAD_REQUEST);
			return rv;
		}
		user = userRepository.findOneByUsername(userDTO.getUsername());
			
			if(user != null) {	
				RedirectView rv = new RedirectView("http://localhost:8080/goodgame/account/register");
				rv.setStatusCode(HttpStatus.BAD_REQUEST);
				return rv;			
			}else {	
				userService.save(userDTO);	
				RedirectView rv = new RedirectView("http://localhost:8080/goodgame/login");
		        rv.setStatusCode(HttpStatus.OK); // set our own status code
		        
		        return rv;
			}
		}
}
	

