package com.goodgame.controller.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.goodgame.service.GameService;

@Controller(value = "HomeControllerOfDashboard")
public class HomeController {
	
	@Autowired
	GameService gameService;
	
	@GetMapping("/dashboard/home")
	public String home() 
	{
		
		return "dashboard/home";
	}
	
	
}
