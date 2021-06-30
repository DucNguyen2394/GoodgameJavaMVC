package com.goodgame.service;

import java.util.List;
import com.goodgame.dto.GameDTO;

public interface IGameService {
	List<GameDTO> findAll();
}
