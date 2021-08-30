package com.goodgame.converter;

import org.springframework.stereotype.Component;

import com.goodgame.constant.SystemConstant;
import com.goodgame.dto.RoleDTO;
import com.goodgame.dto.UserDTO;
import com.goodgame.entity.RoleEntity;
import com.goodgame.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toDto(UserEntity userEntity) {
		UserDTO result = new UserDTO();
		result.setId(userEntity.getId());
		result.setUsername(userEntity.getUsername());
		result.setPassword(userEntity.getPassword());
		result.setFullname(userEntity.getFullname());
		result.setEmail(userEntity.getEmail());
		result.setAge(userEntity.getAge());
		result.setAddress(userEntity.getAddress());
		for(RoleEntity role : userEntity.getRoles()) {
			result.setUserCode(role.getCode());
		}
		result.setStatus(SystemConstant.ACTIVE_STATUS);
		return result;
	}
	
	public UserEntity toEntity(UserDTO userDTO) {
		UserEntity result = new UserEntity();
		result.setUsername(userDTO.getUsername());
		result.setPassword(userDTO.getPassword());
		result.setFullname(userDTO.getFullname());
		result.setEmail(userDTO.getEmail());
		result.setAge(userDTO.getAge());
		result.setAddress(userDTO.getAddress());
		for(int i = 0; i < result.getRoles().size(); i++) {
			result.getRoles().get(i).setCode(userDTO.getUserCode());
		}
		result.setStatus(SystemConstant.ACTIVE_STATUS);
		return result;
	}
	
	public UserEntity toEntity(UserEntity result, UserDTO userDTO) {
		result.setUsername(userDTO.getUsername());
		result.setFullname(userDTO.getFullname());
		result.setEmail(userDTO.getEmail());
		result.setAddress(userDTO.getAddress());
		result.setAge(userDTO.getAge());
	
		return result;
	}
}
