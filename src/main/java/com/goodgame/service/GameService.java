package com.goodgame.service;

import java.util.List;

import com.goodgame.dto.GameDTO;

public interface GameService {
	List<GameDTO> findAll();
	GameDTO findById(long id);
	GameDTO save(GameDTO dto);
}
