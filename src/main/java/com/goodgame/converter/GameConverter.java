package com.goodgame.converter;

import org.springframework.stereotype.Component;
import com.goodgame.dto.GameDTO;
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
		result.setPlatformCode(gameEntity.getPlatform().getCode());
//		result.setCategoryCode(gameEntity.getCategoryEntity().getCode());
		
//		for(int i = 0; i< gameEntity.getCategories().size(); i++) {
//			result.setCategoryCode(gameEntity);			
//		}
		
//		Iterator<CategoryEntity> iterator = (Iterator<CategoryEntity>) gameEntity.getCategories();
//		while(iterator.hasNext()) {
//			result.setCategoryCode(iterator.next().getCode());
//		}
		
		return result;
	}
	
	public GameEntity toEntity(GameDTO gameDTO) {
		GameEntity result = new GameEntity();
		result.setName(gameDTO.getName());
		result.setTitle(gameDTO.getTitle());
		result.setDescription(gameDTO.getDescription());
		result.setContent(gameDTO.getContent());
		return result;
	}
	
	public GameEntity toEntity(GameEntity result ,GameDTO gameDTO) {
		result.setName(gameDTO.getName());
		result.setTitle(gameDTO.getTitle());
		result.setDescription(gameDTO.getDescription());
		result.setContent(gameDTO.getContent());
		return result;
	}
}
