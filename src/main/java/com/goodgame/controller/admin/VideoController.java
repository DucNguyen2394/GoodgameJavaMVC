package com.goodgame.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.goodgame.dto.VideoDTO;
import com.goodgame.service.GameService;
import com.goodgame.service.VideoService;
import com.goodgame.util.MessageUtils;

@Controller
public class VideoController {

	@Autowired
	private VideoService videoService;
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private MessageUtils messageUtils;
	
	@GetMapping("admin/video/list")
	String showList(Model model, 
			@RequestParam("page") int page, 
			@RequestParam("limit") int limit,
			HttpServletRequest request,
			VideoDTO videoDTO) 
	{
		
		videoDTO.setPage(page);
		videoDTO.setLimit(limit);
		
		Pageable pageable = new PageRequest(page - 1,limit);
		videoDTO.setListResult(videoService.findAll(pageable));
		
		videoDTO.setTotalItem(videoService.getTotalItem());
		videoDTO.setTotalPage( (int) Math.ceil((double) videoDTO.getTotalItem() / videoDTO.getLimit()));
		
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
			model.addAttribute("message", message.get("message"));
			model.addAttribute("alert", message.get("alert"));
		}
		model.addAttribute("model", videoDTO);
		return "admin/video/list";
	}
	
	@GetMapping("admin/video/edit")
	String editVideo(@RequestParam(value = "id", required = false) Long id,
			Model model,
			HttpServletRequest request,
			VideoDTO videoDTO) 
	{
		if(id != null) {
			videoDTO = videoService.findById(id);
		}
		
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
			model.addAttribute("message", message.get("message"));
			model.addAttribute("alert", message.get("alert"));
		}
		
		model.addAttribute("games", gameService.findAll());
		model.addAttribute("model", videoDTO);
		return "admin/video/edit";
	}
	
}
