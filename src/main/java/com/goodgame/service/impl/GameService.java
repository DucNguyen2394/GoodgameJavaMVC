package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.goodgame.dto.GameDTO;
import com.goodgame.entity.GameEntity;
import com.goodgame.repository.GameRepository;
import com.goodgame.service.IGameService;

@Service
public class GameService implements IGameService {

	@Autowired
	private GameRepository gameRepository;
	
	public List<GameDTO> findAll() {
		List<GameDTO> dtos = new ArrayList<>();
		List<GameEntity> entities = gameRepository.findAll();
		for(GameEntity gameEntity : entities) {
			GameDTO gameDTO = new GameDTO();
			gameDTO.setName(gameEntity.getName());
			gameDTO.setDescription(gameEntity.getDescription());
			gameDTO.setTitle(gameEntity.getTitle());
			dtos.add(gameDTO);
		}
		return dtos;
	}

}
