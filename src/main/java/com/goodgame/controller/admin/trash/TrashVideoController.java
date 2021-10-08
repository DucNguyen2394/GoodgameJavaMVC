package com.goodgame.controller.admin.trash;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.goodgame.dto.VideoDTO;
import com.goodgame.service.VideoService;

@Controller
public class TrashVideoController {

	@Autowired
	VideoService videoService;
	
	@GetMapping("admin/video/trash")
	public String trashVideo(
			HttpServletRequest request,
			Model model,
			VideoDTO videoDTO) 
	{
		videoDTO.setListResult(videoService.findTrash());
		model.addAttribute("model",videoDTO);
		return "admin/video/trash";
	}
}
