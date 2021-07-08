package com.goodgame.api.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodgame.dto.GameDTO;

@RestController(value = "GameApiOfWeb")
public class GameApi {
	
	@PostMapping("/api/game")
	public GameDTO createGame(@RequestBody GameDTO gameDTO) {
		return gameDTO;
	}
	
	@PutMapping("/api/game")
	public GameDTO updateGame(@RequestBody GameDTO gameDTO) {
		return gameDTO;
	}
	
	@DeleteMapping("/api/game")
	public void deleteGame(@RequestBody long[] ids) {
		System.out.println(ids);
	}
}
