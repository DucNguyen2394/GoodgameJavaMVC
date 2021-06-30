package com.goodgame.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.goodgame.dao.IGameDao;
import com.goodgame.dto.GameDTO;
import com.goodgame.mapper.GameMapper;

@Repository
public class GameDao extends AbstractDao<GameDTO> implements IGameDao {

	@Override
	public List<GameDTO> findAll() {
		String sql = "SELECT * FROM game";
		return query(sql, new GameMapper());
	}

}
