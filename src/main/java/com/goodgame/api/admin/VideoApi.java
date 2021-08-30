package com.goodgame.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodgame.dto.VideoDTO;
import com.goodgame.service.VideoService;

@Controller
public class VideoApi {

	@Autowired
	private VideoService videoService;
	
	@GetMapping("admin/video/list")
	String showList(Model model, 
			@RequestParam("page") int page, 
			@RequestParam("limit") int limit,
			VideoDTO videoDTO) 
	{
		
		videoDTO.setPage(page);
		videoDTO.setLimit(limit);
		
		Pageable pageable = new PageRequest(page - 1,limit);
		videoDTO.setListResult(videoService.findAll(pageable));
		
		videoDTO.setTotalItem(videoService.getTotalItem());
		videoDTO.setTotalPage( (int) Math.ceil(videoDTO.getTotalItem() / videoDTO.getLimit()));
		
		
		model.addAttribute("model", videoDTO);
		return "admin/video/list";
	}
	
}
