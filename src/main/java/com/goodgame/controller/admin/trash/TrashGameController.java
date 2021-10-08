package com.goodgame.controller.admin.trash;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

@Controller(value = "trashGameOfAdmin")
public class TrashGameController {

	@Autowired
	GameService gameService;
		
	@Autowired
	MessageUtils messageUltil;
	
	@GetMapping("admin/game/trash")
	public String trashGame(
			HttpServletRequest request,
			@RequestParam("page") int page,
			@RequestParam("limit") int limit,
			Model model,GameDTO gameDTO) 
	{
		gameDTO.setPage(page);
		gameDTO.setLimit(limit);
		
		Pageable pageable = new PageRequest(page - 1, limit);
		gameDTO.setListResult(gameService.findTrash(pageable));
		gameDTO.setTotalItem(gameService.getTotalItem());
		gameDTO.setTotalPage((int) Math.ceil((double) gameDTO.getTotalItem() / gameDTO.getLimit()));
		HttpSession session = request.getSession();
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUltil.getMessage(request.getParameter("message"));
			session.setAttribute("message", message.get("message"));
			session.setAttribute("alert", message.get("alert"));	
		}
		
		model.addAttribute("model", gameDTO);
		return "admin/game/trash";
	}
	
}
