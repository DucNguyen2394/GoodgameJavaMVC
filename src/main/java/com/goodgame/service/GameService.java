package com.goodgame.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.goodgame.dto.GameDTO;

public interface GameService {
	
	List<GameDTO> findAll(Pageable pageable);
	
	int getTotalItem();
	
	GameDTO findById(long id);
	
	GameDTO save(GameDTO dto);
		
	void delete(long[] ids);
	
	void deleteTrash(long[] ids);
	
	List<GameDTO> findTrash(Pageable pageable);
	
	GameDTO restore(long[] ids);
}
