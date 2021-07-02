package com.goodgame.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.goodgame.entity.UserEntity;
import com.goodgame.service.UserService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
//	@Autowired
//	UserService userService;
//	
//	@Autowired
//	SecurityService securityService;
//	
//	@Autowired
//    private UserValidator userValidator;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("/web/Home");
	      return mav;
	   }
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	   public String login(Model model, String error, String logout) {
//		if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "login";
//	   }
//	
//	@RequestMapping(value = "/registration", method = RequestMethod.GET)
//	   public String register(Model model) {
//	      model.addAttribute("userForm", new UserEntity());
//	      return "register";
//	   }
//	
//	@RequestMapping(value = "/registration", method = RequestMethod.POST)
//	   public String register(@ModelAttribute("userForm") UserEntity userForm, BindingResult bindingResult, Model model) {
//		userValidator.validate(userForm, bindingResult);
//		if (bindingResult.hasErrors()) {
//            return "register";
//        }
//		
////		userService.save(userForm);
//		
//		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
//		
//		return "redirect:/trang-chu";
//	   }
	
}
