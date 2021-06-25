package com.goodgame.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodgame.dao.IGameDao;
import com.goodgame.model.GameModel;
import com.goodgame.service.IGameService;

@Service
public class GameService implements IGameService {

	@Autowired
	private IGameDao gameDao;
	
	public List<GameModel> findAll() {
		return gameDao.findAll();
	}

}
