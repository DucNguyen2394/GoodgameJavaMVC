package com.goodgame.service;

import java.util.List;
import com.goodgame.model.GameModel;

public interface IGameService {
	List<GameModel> findAll();
}
