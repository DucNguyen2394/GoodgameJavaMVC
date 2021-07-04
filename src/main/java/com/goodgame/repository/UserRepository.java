package com.goodgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.goodgame.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByUsernameAndStatus(String name,int status);
		
}
