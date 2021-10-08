package com.goodgame.controller.web.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.goodgame.dto.CategoryDTO;
import com.goodgame.dto.GameDTO;
import com.goodgame.dto.PlatformDTO;
import com.goodgame.entity.CategoryEntity;
import com.goodgame.entity.GameEntity;
import com.goodgame.repository.CategoryRepository;
import com.goodgame.repository.GameRepository;
import com.goodgame.service.CategoryService;
import com.goodgame.service.CookieService;
import com.goodgame.service.GameService;
import com.goodgame.service.PlatformService;

@Controller(value = "gameControllerOfWeb")
public class GameController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	GameService gameService;
	
	@Autowired
	PlatformService platformService;
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	CookieService cookie;
	
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/game/list")
	public String showList(
			@RequestParam("page") int page,
			@RequestParam("limit") int limit,
			Model model,
			GameDTO gameDTO,
			PlatformDTO platformDTO,
			CategoryDTO categoryDTO) 
	{	
		gameDTO.setPage(page);
		gameDTO.setLimit(limit);
		
		Pageable pageable = new PageRequest(page - 1, limit);
		
		gameDTO.setListResult(gameService.findAll(pageable));
		gameDTO.setTotalItem(gameService.getTotalItem());
		gameDTO.setTotalPage((int) Math.ceil((double) gameDTO.getTotalItem() / gameDTO.getLimit()));
		
		categoryDTO.setListResult(categoryService.find());
		
		model.addAttribute("game", gameDTO);
		model.addAttribute("category", categoryDTO);
		
		return "/web/game";
	}
		
	@GetMapping("/game/detail/{id}")
	public String detail(
			@PathVariable("id") Long id,
			Model model,
			CategoryDTO category)
	{		
		Set<GameEntity> games = new HashSet<GameEntity>();
		GameDTO game = gameService.findById(id);
		category.setListResult(categoryService.find());
		GameEntity gameEntity = gameRepository.findOne(id);
		
		for(CategoryEntity item : gameEntity.getCategories()) {
			CategoryEntity cEntity = categoryRepository.findOne(item.getId());
			
			games = cEntity.getGames();
		}
		//set favorite game 
		Cookie favoriteCookie = cookie.read("favorite");
		Set<String> favoriteGame = new HashSet<>();
		if(favoriteCookie != null) {
			String[] names = favoriteCookie.getValue().split(",");
			for(String name : names) {
				favoriteGame.add(name);
			}
			List<GameDTO> favoriteList = gameService.findByNameIn(favoriteGame);
			model.addAttribute("favoriteList", favoriteList);
		}
		// set viewed game
		Cookie viewedCookie = cookie.read("viewed");
		Set<Long> viewedGame = new HashSet<>();
		String value = id.toString();
		if(viewedCookie != null) {
			value = viewedCookie.getValue();
			if(!value.contains(id.toString())) {
				value += "," + id.toString();
			}
			String[] ids = value.split(",");
			for(String gid : ids) {
				viewedGame.add(Long.parseLong(gid));
			}
			List<GameDTO> viewedList = gameService.findByIdIn(viewedGame);
			model.addAttribute("viewedList", viewedList);
		}
		cookie.create("viewed", value, 12);				
		
		model.addAttribute("games", games);
		model.addAttribute("cateName", categoryRepository.findCategoryName(id));
		model.addAttribute("category", category);
		model.addAttribute("game", game);
		return "/web/game/gameDetail/detail";
	}
	
	@ResponseBody
	@RequestMapping("/game/add-to-favorite/{name}")
	public Boolean favorite(
			@PathVariable("name") String name) 
	{
		Cookie favoriteCookie = cookie.read("favorite");
		String value = name ;
		if(favoriteCookie != null) {
			value = favoriteCookie.getValue();
			if(!value.contains(name)) {
				value += "," + name;				
			}
			else {
				return false;
			}
		}
		
		cookie.create("favorite", value, 12);
		return true;
	}

}
