package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.goodgame.constant.SystemConstant;
import com.goodgame.converter.CategoryConverter;
import com.goodgame.dto.CategoryDTO;
import com.goodgame.entity.CategoryEntity;
import com.goodgame.repository.CategoryRepository;
import com.goodgame.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CategoryConverter categoryConverter;

	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		List<CategoryDTO> result = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll(pageable).getContent();
		for(CategoryEntity categoryEntity : entities) {
			if(categoryEntity.getStatus() == 1) {
				CategoryDTO dto = categoryConverter.toDto(categoryEntity);
				result.add(dto);
			}
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

	@Override
	public int getTotalItem() {
		
		return (int) categoryRepository.count();
	}

	@Override
	public CategoryDTO findById(long id) {
		CategoryEntity categoryEntity = categoryRepository.findOne(id);
		return categoryConverter.toDto(categoryEntity);
	}

	@Override
	@Transactional
	public CategoryDTO save(CategoryDTO dtos) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if(dtos.getId() != null) {
			CategoryEntity oldCategory = categoryRepository.findOne(dtos.getId());
			categoryEntity = categoryConverter.toEntity(oldCategory, dtos);
		}else {
			categoryEntity = categoryConverter.toEntity(dtos);
		}
		return categoryConverter.toDto(categoryRepository.save(categoryEntity));
	}

	@Override
	@Transactional
	public void deleteTrash(long[] ids) {
		for(long id : ids) {
			categoryRepository.delete(id);
		}
	}

	@Override
	public List<CategoryDTO> findTrash(Pageable pageable) {
		List<CategoryDTO> dtos = new ArrayList<>();
		
		List<CategoryEntity> entities = categoryRepository.findAll(pageable).getContent();
		
		for(CategoryEntity categoryEntity : entities) {
			if(categoryEntity.getStatus() == 0) {
				CategoryDTO categoryDTO = categoryConverter.toDto(categoryEntity);
				dtos.add(categoryDTO);
			}
		}
		return dtos;
	}

	@Override
	public CategoryDTO restore(long[] ids) {
		CategoryEntity categoryEntity = new CategoryEntity();
		for(long id : ids) {
			categoryEntity = categoryRepository.findOne(id);
			categoryEntity.setStatus(SystemConstant.ACTIVE_STATUS);
		}
		return categoryConverter.toDto(categoryRepository.save(categoryEntity));
	}

	@Override
	public void delete(long[] ids) {
		CategoryEntity categoryEntity = new CategoryEntity();
		for(long id : ids) {
			categoryEntity = categoryRepository.findOne(id);
			categoryEntity.setStatus(SystemConstant.INACTIVE_STATUS);
		}
		
	}
	
}
