package com.goodgame.dao;

import java.util.List;

import com.goodgame.model.GameModel;

public interface IGameDao extends GenericDao<GameModel> {
	List<GameModel> findAll();
}
