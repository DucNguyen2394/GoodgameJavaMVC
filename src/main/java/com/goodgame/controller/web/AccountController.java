package com.goodgame.controller.web;

import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.goodgame.entity.UserEntity;
import com.goodgame.repository.UserRepository;
import com.goodgame.service.MailService;
import com.goodgame.service.UserService;
import com.goodgame.util.Utility;

import net.bytebuddy.utility.RandomString;

@Controller
public class AccountController {
	
	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("account/login");
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


	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("/account/register");
		mav.addObject("form", new UserEntity());
		return mav;
	}
	
	@GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
		return "account/forgot_password";
    }
     
	@PostMapping("/forgot_password")
    public String processForgotPasswordForm(HttpServletRequest request, Model model,
    		UserEntity userEntity,@RequestParam("email") String email) {
		
//		String email = request.getParameter("email");	
	    String token = RandomString.make(30);
	    System.err.println("token: " + token);
	    
	    userEntity = userRepository.findOneByEmail(email);
	    if(userEntity == null ) {
	    	model.addAttribute("err", "email not found");

	    	return "account/forgot_password";
	    }
	    try {
	    	userService.updateResetPasswordToken(token, email);
	        String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
	        mailService.sendMail(email, resetPasswordLink);
	        model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
	        
	    } catch (UnsupportedEncodingException | MessagingException e) {
	        model.addAttribute("error", "Error while sending email");
	    }
	    return "redirect:/forgot_password?success";
    }
     
    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        UserEntity user = userService.getByResetPasswordToken(token);
        model.addAttribute("token", token);
         
        if (user == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        }
         
        return "account/reset_password_form";
    }
    
    @PostMapping("/reset_password")
    public String processResetPassword() {
    	return null;
    }

}
