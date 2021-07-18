package com.goodgame.service;

import java.util.List;
import java.util.Map;

import com.goodgame.dto.CategoryDTO;

public interface CategoryService {
	Map<String,String> findAll();
	List<CategoryDTO> findAl();
}
