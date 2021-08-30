package com.goodgame.api.admin.trash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodgame.dto.CategoryDTO;
import com.goodgame.service.CategoryService;

@RestController
public class TrashCategoryApi {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("api/category/trash")
	public CategoryDTO restoreCategory(@RequestBody long[] ids) {		
		return categoryService.restore(ids);
	}
	
	@DeleteMapping("api/category/trash")
	public void deleteCategory(@RequestBody long[] ids) {
		categoryService.deleteTrash(ids);
	}
}
