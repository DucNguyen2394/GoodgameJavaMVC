package com.goodgame.converter;

import org.springframework.stereotype.Component;
import com.goodgame.dto.CategoryDTO;
import com.goodgame.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryDTO toDto(CategoryEntity categoryEntity) {
		CategoryDTO result = new CategoryDTO();
		result.setId(categoryEntity.getId());
		result.setCode(categoryEntity.getCode());
		result.setName(categoryEntity.getName());
		return result;
		
	}
	
	public CategoryEntity toEntity(CategoryDTO categoryDTO) {
		CategoryEntity result = new CategoryEntity();
		result.setCode(categoryDTO.getCode());
		result.setName(categoryDTO.getName());
		
		return result;
	}
}
