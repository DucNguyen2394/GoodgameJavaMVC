package com.goodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.goodgame.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode(String code);
	CategoryEntity findOneByName(String name);
	
	@Query("SELECT category.name FROM CategoryEntity category JOIN category.games games WHERE games.id = (?1)")
	List<String> findCategoryName(Long id);
}
