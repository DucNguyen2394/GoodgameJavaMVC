package com.goodgame.converter;

import org.springframework.stereotype.Component;
import com.goodgame.constant.SystemConstant;
import com.goodgame.dto.CategoryDTO;
import com.goodgame.dto.GameDTO;
import com.goodgame.entity.CategoryEntity;
import com.goodgame.entity.GameEntity;

@Component
public class GameConverter {
	
	public GameDTO toDto(GameEntity gameEntity) {
		GameDTO result = new GameDTO();
		result.setId(gameEntity.getId());
		result.setName(gameEntity.getName());
		result.setTitle(gameEntity.getTitle());
		result.setDescription(gameEntity.getDescription());
		result.setContent(gameEntity.getContent());
		result.setThumbnail(gameEntity.getThumbnail());
		result.setPlatformCode(gameEntity.getPlatform().getCode());
		
//		for(CategoryEntity category : gameEntity.getCategories()) {
//			result.setCategoryId(category.getId());
//			result.setCategories(category.getCode());
//			
//		}
		
		result.setStatus(SystemConstant.ACTIVE_STATUS);
		
		return result;
	}
	
	public GameEntity toEntity(GameDTO gameDTO) {
		GameEntity result = new GameEntity();
		result.setName(gameDTO.getName());
		result.setTitle(gameDTO.getTitle());
		result.setDescription(gameDTO.getDescription());
		result.setContent(gameDTO.getContent());
		result.setThumbnail(gameDTO.getThumbnail());
//		result.getCategories().add(new CategoryEntity());
	
		result.setStatus(SystemConstant.ACTIVE_STATUS);
		return result;
	}
	
	public GameEntity toEntity(GameEntity result ,GameDTO gameDTO) {
		result.setName(gameDTO.getName());
		result.setTitle(gameDTO.getTitle());
		result.setDescription(gameDTO.getDescription());
		result.setContent(gameDTO.getContent());
		result.setThumbnail(gameDTO.getThumbnail());
		return result;
	}
	
}
