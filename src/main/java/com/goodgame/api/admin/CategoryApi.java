package com.goodgame.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodgame.dto.CategoryDTO;
import com.goodgame.entity.CategoryEntity;
import com.goodgame.repository.CategoryRepository;
import com.goodgame.service.CategoryService;

@RestController
public class CategoryApi {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping("/api/category")
	public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO,Model model,CategoryEntity categoryEntity){
		categoryEntity = categoryRepository.findOneByName(categoryDTO.getName());
		categoryEntity = categoryRepository.findOneByCode(categoryDTO.getCode());
		if(categoryEntity != null){

			return (CategoryDTO) model.addAttribute("error", "Category name is exist!");
		}
		return categoryService.save(categoryDTO);
	}
	
	@PutMapping("/api/category")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.save(categoryDTO);
	}
	
	@DeleteMapping("/api/category")
	public void deleteCategory(@RequestBody long[] ids) {
		categoryService.delete(ids);
	}
}
