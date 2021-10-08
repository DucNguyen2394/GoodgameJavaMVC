package com.goodgame.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import com.goodgame.dto.GameDTO;

public interface GameService {
	
	Map<String,String> findAll();
	
	List<GameDTO> findAll(Pageable pageable);
	
	int getTotalItem();
	
	int getTotalItemTrash();
	
	GameDTO findById(long id);
	
	GameDTO save(GameDTO dto);
		
	void delete(long[] ids);
	
	void deleteTrash(long[] ids);
	
	List<GameDTO> findTrash(Pageable pageable);
	
	GameDTO restore(long id);
	
	List<GameDTO> findTop12ByOrderByCreateDateDesc();
	
	List<GameDTO> findByNameIn(Set<String> names);
	
	List<GameDTO> findByIdIn(Set<Long> id);
}
