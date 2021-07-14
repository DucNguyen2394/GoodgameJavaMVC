package com.goodgame.converter;

import org.springframework.stereotype.Component;
import com.goodgame.dto.UserDTO;
import com.goodgame.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toDto(UserEntity userEntity) {
		UserDTO result = new UserDTO();
		result.setId(userEntity.getId());
		result.setUsername(userEntity.getUsername());
		result.setPassword(userEntity.getPassword());
		result.setFullname(userEntity.getFullname());
//		result.setEmail(userEntity.getEmail());
		result.setAge(userEntity.getAge());
		result.setAddress(userEntity.getAddress());
		result.setStatus(1);
		return result;
	}
	
	public UserEntity toEntity(UserDTO userDTO) {
		UserEntity result = new UserEntity();
		result.setUsername(userDTO.getUsername());
		result.setPassword(userDTO.getPassword());
		result.setFullname(userDTO.getFullname());
//		result.setEmail(userDTO.getEmail());
		result.setAge(userDTO.getAge());
		result.setAddress(userDTO.getAddress());
		result.setStatus(1);
		return result;
	}
}
