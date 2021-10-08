package com.goodgame.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.goodgame.dto.GameDTO;
import com.goodgame.repository.GameRepository;
import com.goodgame.service.GameService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	@Autowired
	GameService gameService;
	
	@Autowired
	GameRepository gameRepository;
	
	@GetMapping("/trang-chu")
	public String homePage(
			Model model,
			GameDTO gameDTO) 
	{
		gameDTO.setListResult(gameService.findTop12ByOrderByCreateDateDesc());
		model.addAttribute("game", gameDTO);
		return "/web/home";
	}
	
}
