package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.goodgame.constant.SystemConstant;
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
@Transactional
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private GameConverter gameConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PlatformRepository platformRepository;
	
	@Override
	public Map<String,String> findAll(){
		Map<String,String> result = new HashMap<>();
		List<GameEntity> entites = gameRepository.findAll();
		for(GameEntity entity : entites) {
			result.put(entity.getName(), entity.getName());
		}
		return result;
	}
	
	@Override
	public List<GameDTO> findAll(Pageable pageable) {
		List<GameDTO> dtos = new ArrayList<>();
		
		List<GameEntity> entities = gameRepository.findAll(pageable).getContent();
		
		for(GameEntity gameEntity : entities) {
			if(gameEntity.getStatus() == SystemConstant.ACTIVE_STATUS) {
				GameDTO gameDTO = gameConverter.toDto(gameEntity);
				System.err.println("name : " + gameDTO.getName());
				dtos.add(gameDTO);
			}
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
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(dto.getCategoryCode());

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
	
	@Override
	public int getTotalItem() {
		return (int) gameRepository.countAppear();
	}
	
	@Override
	public int getTotalItemTrash() {
		return (int) gameRepository.countDelete();
	}
	
	@Override
	@Transactional
	public void deleteTrash(long[] ids) {
		for(long id : ids) {			
			gameRepository.delete(id);
		}
	}
	
	@Override
	public List<GameDTO> findTrash(Pageable pageable) {
		List<GameDTO> dtos = new ArrayList<>();
		
		List<GameEntity> entities = gameRepository.findAll(pageable).getContent();
		
		for(GameEntity gameEntity : entities) {
			if(gameEntity.getStatus() == SystemConstant.INACTIVE_STATUS) {
				GameDTO gameDTO = gameConverter.toDto(gameEntity);
				dtos.add(gameDTO);
			}
		}
		return dtos;
	}
	
	@Override
	public GameDTO restore(long id) {
		GameEntity gameEntity = new GameEntity();
		gameEntity = gameRepository.findOne(id);
			
		gameEntity.setStatus(SystemConstant.ACTIVE_STATUS);			
		return gameConverter.toDto(gameRepository.save(gameEntity));			
	}

	@Override
	public void delete(long[] ids) {
		GameEntity gameEntity = new GameEntity();
		for(long id : ids) {
			gameEntity = gameRepository.findOne(id);
			gameEntity.setStatus(SystemConstant.INACTIVE_STATUS);
		}
	}

	@Override
	public List<GameDTO> findTop12ByOrderByCreateDateDesc() {
		List<GameDTO> games = new ArrayList<GameDTO>();
		List<GameEntity> entities = gameRepository.findTop12ByOrderByCreateDateDesc();
		int i = 0;
		for(GameEntity gameEntity : entities) {
			GameDTO gameDTO = gameConverter.toDto(gameEntity);
			games.add(gameDTO);			
			i++;
			if(i == SystemConstant.FEATURED) break;
		}
		
		return games;
	}

	@Override
	public List<GameDTO> findByNameIn(Set<String> names) {
		List<GameDTO> games = new ArrayList<GameDTO>();
		List<GameEntity> entities = gameRepository.findByNameIn(names);
		for(GameEntity entity : entities) {
			GameDTO game = gameConverter.toDto(entity);
			games.add(game);
		}
		return games;
	}
	
	@Override
	public List<GameDTO> findByIdIn(Set<Long> id) {
		List<GameDTO> games = new ArrayList<GameDTO>();
		List<GameEntity> entities = gameRepository.findByIdIn(id);
		for(GameEntity entity : entities) {
			GameDTO game = gameConverter.toDto(entity);
			games.add(game);
		}
		return games;
	}
}
