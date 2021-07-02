package com.goodgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodgame.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
