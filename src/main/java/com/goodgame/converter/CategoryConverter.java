package com.goodgame.converter;

import org.springframework.stereotype.Component;

import com.goodgame.constant.SystemConstant;
import com.goodgame.dto.CategoryDTO;
import com.goodgame.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	public CategoryDTO toDto(CategoryEntity categoryEntity) {
		CategoryDTO result = new CategoryDTO();
		result.setId(categoryEntity.getId());
		result.setName(categoryEntity.getName());
		result.setCode(categoryEntity.getCode());
		
		return result;
		
	}
	
	public CategoryEntity toEntity(CategoryDTO categoryDTO) {
		CategoryEntity result = new CategoryEntity();
		result.setName(categoryDTO.getName());
		result.setCode(categoryDTO.getCode());
		result.setStatus(SystemConstant.ACTIVE_STATUS);
		return result;
	}
	
	public CategoryEntity toEntity(CategoryEntity result, CategoryDTO categoryDTO) {
		result.setCode(categoryDTO.getCode());
		result.setName(categoryDTO.getName());
		result.setStatus(SystemConstant.ACTIVE_STATUS);
		return result;
	}
}
