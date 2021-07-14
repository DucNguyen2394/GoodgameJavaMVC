package com.goodgame.converter;

import com.goodgame.dto.RoleDTO;
import com.goodgame.entity.RoleEntity;

public class RoleConverter {
	public RoleDTO toDto(RoleEntity roleEntity) {
		RoleDTO result = new RoleDTO();
		result.setId(roleEntity.getId());
		result.setName(roleEntity.getName());
		result.setCode(roleEntity.getCode());
		return result;
	}
	
	public RoleEntity toEntity(RoleDTO roleDTO) {
		RoleEntity result = new RoleEntity();
		result.setName(roleDTO.getName());
		result.setCode(roleDTO.getCode());
		return result;
	}
}
