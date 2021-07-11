package com.goodgame.converter;

import com.goodgame.dto.UserDTO;
import com.goodgame.entity.UserEntity;

public class UserConverter {
	public UserDTO toDto(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(userEntity.getUsername());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setFullname(userEntity.getFullname());
		userDTO.setAge(userEntity.getAge());
		userDTO.setAddress(userEntity.getAddress());
		
		return userDTO;
	}
}
