package com.goodgame.controller.web.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodgame.dto.CategoryDTO;
import com.goodgame.entity.CategoryEntity;
import com.goodgame.entity.GameEntity;
import com.goodgame.repository.CategoryRepository;
import com.goodgame.repository.GameRepository;
import com.goodgame.service.CategoryService;

@Controller
public class GameListByController {
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/game/list-by-category/{cid}")
	public void listByCategory(
			@PathVariable("cid") long categoryId,
			Model model,
			CategoryDTO categoryDTO,
			HttpServletResponse response,
			HttpServletRequest request) throws IOException 
	{
		
		categoryDTO.setListResult(categoryService.find());
		CategoryEntity cEntity = categoryRepository.findOne(categoryId);
		
		Collection<GameEntity> games = cEntity.getGames();
		
		PrintWriter out = response.getWriter();
		
		for(GameEntity game : games) {
			out.println(
						"<div class=\"col-lg-6 col-xl-3 animate__animated animate__zoomIn wow\" data-wow-delay=\"0.5s\">\r\n"
					+ "		<div class=\"category-img\" data-id=\"${item.id}\">\r\n"
					+ "		    <a href=\"#\"><img src=\""+ request.getContextPath() +"/template/web/img/games/the-witcher-1-384x488.jpg\"></img></a>\r\n"
					+ "		    	<div class=\"genre\">\r\n"
					+ "		    <a href=\"#\"> Action,Adventure</a>\r\n"
					+ "		   	<i class=\"fas fa-tags\"></i>\r\n"
					+ "		    </div>\r\n"
					+ "		    <div class=\"favor btn-favor\" data-id=\""+game.getId()+"\">\r\n"
					+ "		       <i class=\"fas fa-star\"></i>\r\n"
					+ "		    </div>\r\n"
					+ "		    </div>\r\n"
					+ "		    <div class=\"list-title\">\r\n"
					+ "		     <a href=\"${pageContext.request.contextPath}/game/detail/"+game.getId()+"\">\r\n"
					+ "		          "+game.getName()+"\r\n"
					+ "		     </a>\r\n"
					+ "		     </div>\r\n"
					+ "		     <div class=\"platform\">\r\n"
					+ "		          <i class=\"fas fa-tv\"></i>\r\n"
					+ "		      	<a href=\"#\"> PC,PS5,Steam</a>\r\n"
					+ "		      </div>\r\n"
					+ "		      <div class=\"summary\">\r\n"
					+ "		           <p>"+game.getTitle()+"</p>\r\n"
					+ "		      </div>\r\n"
					+ "		</div> ");
			
		}
		
	}
	
	@GetMapping("/game/list-by-keyword")
	public String listByKeyword(
			@RequestParam("keyword") String keyword,
			Model model)
	{
		List<GameEntity> games = gameRepository.search(keyword);
		model.addAttribute("game", games);
		return "/web/game/list/list-by-keyword";
	}
}
