package com.goodgame.controller.admin;

import java.util.List;
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
import com.goodgame.dto.RoleDTO;
import com.goodgame.dto.UserDTO;
import com.goodgame.entity.RoleEntity;
import com.goodgame.entity.UserEntity;
import com.goodgame.repository.RoleRepository;
import com.goodgame.repository.UserRepository;
import com.goodgame.service.RoleService;
import com.goodgame.service.UserService;
import com.goodgame.util.MessageUtils;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired 
	RoleService roleService;
	
	@Autowired
	MessageUtils messageUtil;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@GetMapping("admin/user/list")
	public String showList(
			@RequestParam("page") int page,
			@RequestParam("limit") int limit,
			HttpServletRequest request,
			Model model,
			UserDTO userDTO) 
	{
		Pageable pageable = new PageRequest(page - 1, limit);
		userDTO.setListResult(userService.findAll(pageable));
		userDTO.setPage(page);
		userDTO.setLimit(limit);
		userDTO.setTotalItem(userService.getTotalItem());
		userDTO.setTotalPage((int) Math.ceil((double) userDTO.getTotalItem() / userDTO.getLimit()));
		
		HttpSession session = request.getSession();
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter(("message")));
			session.setAttribute("message", message.get("message"));
			session.setAttribute("alert", message.get("alert"));
		}
		model.addAttribute("model",userDTO);
		return "admin/user/list";
	}
	
	@GetMapping("admin/user/edit")
	public String editUser(
			@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request,
			Model model,
			UserDTO userDTO) 
	{
		if(id != null) {
			userDTO = userService.findById(id);
		}
		if(request.getParameter("message") != null) {
			Map<String,String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addAttribute("message", message.get("message"));
			model.addAttribute("alert", message.get("alert"));
		}
		
		model.addAttribute("roles", roleService.findAll());
		
		model.addAttribute("model", userDTO);
		return "admin/user/edit";
	}
}
