package com.goodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodgame.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findOneByCode(String code);
	
	List<RoleEntity> findAllByCode(String[] code);

}
