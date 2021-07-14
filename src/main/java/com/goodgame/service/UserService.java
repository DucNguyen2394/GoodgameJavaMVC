package com.goodgame.service;

import com.goodgame.dto.UserDTO;
import com.goodgame.entity.UserEntity;

public interface UserService {
	void save(UserEntity user);

    UserDTO findByUsername(String username);
    
    UserDTO save(UserDTO dto);
}
