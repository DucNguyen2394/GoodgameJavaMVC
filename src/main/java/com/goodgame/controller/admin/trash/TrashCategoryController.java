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

import com.goodgame.dto.CategoryDTO;
import com.goodgame.service.CategoryService;
import com.goodgame.util.MessageUtils;

@Controller
public class TrashCategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	MessageUtils messageUtil;
	
	@GetMapping("admin/category/trash")
	public String trashCategory(
			HttpServletRequest request,
			@RequestParam("page") int page, 
			@RequestParam("limit") int limit, 
			Model model,CategoryDTO categoryDTO) 
	{
		
		categoryDTO.setPage(page);
		categoryDTO.setLimit(limit);
		
		Pageable pegaeble = new PageRequest(page - 1, limit);
		categoryDTO.setListResult(categoryService.findTrash(pegaeble));
		categoryDTO.setTotalItem(categoryService.getTotalItem());
		categoryDTO.setTotalPage((int) Math.ceil((double) categoryDTO.getTotalItem() / categoryDTO.getLimit()));
		
		HttpSession session = request.getSession();
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			session.setAttribute("message", message.get("message"));
			session.setAttribute("alert", message.get("alert"));
		}
		
		model.addAttribute("model", categoryDTO);
		return "admin/category/trash";
	}
}
