package com.goodgame.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.goodgame.dao.IGameDao;
import com.goodgame.mapper.GameMapper;
import com.goodgame.model.GameModel;

@Repository
public class GameDao extends AbstractDao<GameModel> implements IGameDao {

	@Override
	public List<GameModel> findAll() {
		String sql = "SELECT * FROM game";
		return query(sql, new GameMapper());
	}

}
