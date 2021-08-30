package com.goodgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodgame.entity.GameEntity;

public interface GameRepository extends JpaRepository<GameEntity, Long> {
	
}
