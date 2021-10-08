package com.goodgame.controller.dashboard;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.goodgame.dto.GameDTO;
import com.goodgame.service.CategoryService;
import com.goodgame.service.GameService;
import com.goodgame.service.PlatformService;
import com.goodgame.util.MessageUtils;

@Controller(value = "GameControllerOfDashboard")
public class GameController {

	@Autowired
	GameService gameService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PlatformService platformService;
	
	@Autowired
	MessageUtils messageUtil;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@GetMapping("dashboard/game/list")
	public String gameList(
			@RequestParam("page") int page,
			@RequestParam("limit") int limit,
			Model model,
			GameDTO gameDTO) 
	{
		Pageable pageable = new PageRequest(page - 1, limit);
		gameDTO.setPage(page);
		gameDTO.setLimit(limit);
		
		gameDTO.setTotalItem(gameService.getTotalItem());		
		gameDTO.setTotalPage((int) Math.ceil((double) gameDTO.getTotalItem() / gameDTO.getLimit())); 
		
		System.err.println("total item : " + gameDTO.getTotalItem());
		System.err.println("total page : " + gameDTO.getTotalPage());
		
		gameDTO.setListResult(gameService.findAll(pageable));
		System.err.println("total list : " + gameDTO.getListResult());
		HttpSession session = request.getSession();
	      if(request.getParameter("message") != null) {
	    	  Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
	    	  session.setAttribute("message", message.get("message"));
	    	  session.setAttribute("alert", message.get("alert"));
	      }
		
		model.addAttribute("gameDTO", gameDTO);
		return"/dashboard/game/list";
	}
	
	@GetMapping("dashboard/game/edit")
	public String gameEdit(
			@RequestParam(value = "id", required = false) Long id,
			Model model,
			GameDTO gameDTO) 
	{
		if(id != null) {
			gameDTO = gameService.findById(id);
		}
		
		if(request.getParameter("message") != null) {
			Map<String,String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addAttribute("message", message.get("message"));
			model.addAttribute("alert", message.get("alert"));
		}
		
		model.addAttribute("categories", categoryService.find());
		model.addAttribute("platforms", platformService.findAll());
		model.addAttribute("gameDTO", gameDTO);
		return "dashboard/game/edit";
	}
}
