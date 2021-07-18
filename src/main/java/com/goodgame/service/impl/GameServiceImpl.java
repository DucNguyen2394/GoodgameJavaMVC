package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goodgame.converter.GameConverter;
import com.goodgame.dto.GameDTO;
import com.goodgame.entity.CategoryEntity;
import com.goodgame.entity.GameEntity;
import com.goodgame.entity.PlatformEntity;
import com.goodgame.repository.CategoryRepository;
import com.goodgame.repository.GameRepository;
import com.goodgame.repository.PlatformRepository;
import com.goodgame.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private GameConverter gameConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PlatformRepository platformRepository;
	
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

	@Override
	@Transactional
	public GameDTO save(GameDTO dto) {
		CategoryEntity categoryEntity =  categoryRepository.findOneByCode(dto.getCategoryCode());
		PlatformEntity platformEntity = platformRepository.findOneByCode(dto.getPlatformCode());
		GameEntity gameEntity = new GameEntity();
		if(dto.getId() != null) {
			GameEntity oldGame = gameRepository.findOne(dto.getId());
			oldGame.getCategories().add(categoryEntity);
			oldGame.setPlatform(platformEntity);
			gameEntity = gameConverter.toEntity(oldGame, dto);
		}else {
			gameEntity = gameConverter.toEntity(dto);
			gameEntity.getCategories().add(categoryEntity);
			gameEntity.setPlatform(platformEntity);
		}
		return gameConverter.toDto(gameRepository.save(gameEntity));
	}

}
