package com.goodgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodgame.entity.PlatformEntity;

public interface PlatformRepository extends JpaRepository<PlatformEntity, Long> {
	PlatformEntity findOneByCode(String code);
}
