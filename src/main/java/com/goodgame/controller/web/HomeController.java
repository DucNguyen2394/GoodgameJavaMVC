package com.goodgame.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.goodgame.dto.UserDTO;
import com.goodgame.entity.UserEntity;
import com.goodgame.service.UserService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("/web/Home");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/login?accessDenied");
	}


	@RequestMapping(value = "/account/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("/register");
		mav.addObject("form", new UserEntity());
		return mav;
	}
	
//	@PostMapping(value = "/account/register")
//	public String createAccount(Model model, @Validated @ModelAttribute("form") UserEntity user, BindingResult errors) {
//
//		if(errors.hasErrors()) {
//			model.addAttribute("message","Please fix some following errors");
//			return "/account/register";
//		}else {
//			UserDTO userDto = userService.findByUsername(user.getUsername());
//			if(userDto != null) {
//				model.addAttribute("message", "Username is in used");
//				return "/account/register";
//			}
//		}
//		
//		
//		return "redirect:/trang-chu";
//	}

}
