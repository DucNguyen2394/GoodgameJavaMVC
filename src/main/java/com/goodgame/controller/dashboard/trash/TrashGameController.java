package com.goodgame.controller.dashboard.trash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodgame.dto.GameDTO;
import com.goodgame.service.GameService;
import com.goodgame.util.MessageUtils;

@Controller(value = "trashGameOfDashboard")
public class TrashGameController {
	
	@Autowired
	GameService gameService;
	
	@Autowired
	MessageUtils messageUtils;
	
	@GetMapping("dashboard/game/trash")
	public String trash(
			@RequestParam("page") int page,
			@RequestParam("limit") int limit,
			GameDTO gameDTO,
			Model model)
	{
		gameDTO.setPage(page);
		gameDTO.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1,limit);
		gameDTO.setListResult(gameService.findTrash(pageable));
		gameDTO.setTotalItem(gameService.getTotalItemTrash());
		
		gameDTO.setTotalPage((int) Math.ceil((double) gameDTO.getTotalItem() / gameDTO.getLimit()));
		
		model.addAttribute("gameDTO", gameDTO);
		
		return "dashboard/game/trash";
	}
}
