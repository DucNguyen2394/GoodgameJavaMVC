package com.goodgame.converter;

import org.springframework.stereotype.Component;

import com.goodgame.dto.PlatformDTO;
import com.goodgame.entity.PlatformEntity;

@Component
public class PlatformConverter {
	public PlatformDTO toDto(PlatformEntity platformEntity) {
		PlatformDTO result = new PlatformDTO();
		result.setId(platformEntity.getId());
		result.setCode(platformEntity.getCode());
		result.setName(platformEntity.getName());
		return result;
	}
	
	public PlatformEntity toEntity(PlatformDTO platformDTO) {
		PlatformEntity result = new PlatformEntity();
		result.setName(platformDTO.getName());
		result.setCode(platformDTO.getCode());
		
		return result;
	}
}
