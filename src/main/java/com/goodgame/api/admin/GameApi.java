package com.goodgame.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.goodgame.dto.GameDTO;
import com.goodgame.service.GameService;

@RestController
public class GameApi {
	
	@Autowired
	private GameService gameService;
	
	@PostMapping("/api/game")
	public GameDTO createGame(@RequestBody GameDTO gameDTO){	
		return gameService.save(gameDTO);
	}
	
	@PutMapping("/api/game")
	public GameDTO updateGame(@RequestBody GameDTO gameDTO) {
		return gameService.save(gameDTO);
	}
	
	@DeleteMapping("/api/game")
	public void deleteGame(@RequestBody long[] ids) {
		gameService.delete(ids);
	}
}
