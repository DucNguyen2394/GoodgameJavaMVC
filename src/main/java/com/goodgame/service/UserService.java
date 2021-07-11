package com.goodgame.service;

import com.goodgame.entity.UserEntity;

public interface UserService {
	void save(UserEntity user);

    UserEntity findByUsername(String username);
    
}
