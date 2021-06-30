package com.goodgame.dao;

import java.util.List;
import com.goodgame.dto.GameDTO;

public interface IGameDao extends GenericDao<GameDTO> {
	List<GameDTO> findAll();
}
