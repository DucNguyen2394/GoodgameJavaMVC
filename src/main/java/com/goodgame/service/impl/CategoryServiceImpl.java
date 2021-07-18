package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.goodgame.converter.CategoryConverter;
import com.goodgame.dto.CategoryDTO;
import com.goodgame.entity.CategoryEntity;
import com.goodgame.repository.CategoryRepository;
import com.goodgame.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CategoryConverter categoryConverter;

	@Override
	public Map<String,String> findAll() {
		Map<String,String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity item : entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}

	@Override
	public List<CategoryDTO> findAl() {
		List<CategoryDTO> result = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity item : entities) {
			CategoryDTO dto = categoryConverter.toDto(item);
			result.add(dto);
		}
		return result;
	}

}
