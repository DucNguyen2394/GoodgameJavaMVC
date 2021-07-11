package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.goodgame.converter.GameConverter;
import com.goodgame.dto.GameDTO;
import com.goodgame.entity.GameEntity;
import com.goodgame.repository.GameRepository;
import com.goodgame.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private GameConverter gameConverter;
	
	public List<GameDTO> findAll() {
		List<GameDTO> dtos = new ArrayList<>();
		List<GameEntity> entities = gameRepository.findAll();
		for(GameEntity gameEntity : entities) {
			GameDTO gameDTO = gameConverter.toDto(gameEntity);
			dtos.add(gameDTO);
		}
		return dtos;
	}

	@Override
	public GameDTO findById(long id) {
		GameEntity gameEntity = gameRepository.findOne(id);
		return gameConverter.toDto(gameEntity);
	}

}
