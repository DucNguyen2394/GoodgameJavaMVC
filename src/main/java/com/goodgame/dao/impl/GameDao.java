package com.goodgame.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.goodgame.dao.IGameDao;
import com.goodgame.mapper.RowMapper;
import com.goodgame.model.GameModel;

@Repository
public class GameDao extends AbstractDao<GameModel> implements IGameDao {

	@Override
	public List<GameModel> findAll() {
		return null;
	}

	@Override
	public List<GameModel> query(String sql, RowMapper<GameModel> rowMapper, Object... params) {
		return null;
	}

}
