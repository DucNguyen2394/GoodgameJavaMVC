package com.goodgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodgame.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode(String code);
}
