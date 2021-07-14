package com.goodgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.goodgame.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findOneByUsernameAndStatus(String name,int status);
	UserEntity findOneByUsername(String username);
}
