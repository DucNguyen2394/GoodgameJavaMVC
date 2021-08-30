package com.goodgame.controller.admin.trash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodgame.dto.UserDTO;
import com.goodgame.service.UserService;

@Controller
public class TrashUserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("admin/user/trash")
	public String TrashUser(
			@RequestParam(value = "page") int page,
			@RequestParam(value = "limit") int limit,
			Model model,
			UserDTO userDTO) 
	{
		userDTO.setPage(page);
		userDTO.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		userDTO.setListResult(userService.findTrash(pageable));
		userDTO.setTotalItem(userService.getTotalItem());
		userDTO.setTotalPage((int) Math.ceil(userDTO.getTotalItem() / userDTO.getLimit()));
		
		model.addAttribute("model", userDTO);
		return "admin/user/trash";
	}
}
