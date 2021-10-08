package com.goodgame.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.goodgame.dto.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> findAll(Pageable pageable);
	
	List<CategoryDTO> find();
	
	int getTotalItem();
	
	CategoryDTO findById(long id);
	
	CategoryDTO save(CategoryDTO dtos);
	
	void deleteTrash(long[] ids);
	
	List<CategoryDTO> findTrash(Pageable pageable);
	
	CategoryDTO restore(long[] ids);
	
	void delete(long[] ids);
}
