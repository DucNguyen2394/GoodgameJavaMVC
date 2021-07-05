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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.goodgame.entity.UserEntity;
import com.goodgame.service.UserService;
import com.goodgame.validator.UserValidator;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	UserService userService;
	 

//	@Autowired
//    private UserValidator userValidator;

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

//
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public String register(Model model) {
//		model.addAttribute("userForm", new UserEntity());
//		return "register";
//	}

//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	   public String register(@ModelAttribute("userForm") UserEntity userForm, BindingResult bindingResult, Model model) {
//			userValidator.validate(userForm, bindingResult);
//			if (bindingResult.hasErrors()) {
//	            return "register";
//        }
//		
//			userService.save(userForm);
//			
//			securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
//			
//			return "redirect:/trang-chu";
//	   }

}
