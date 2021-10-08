package com.goodgame.api.admin.trash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodgame.dto.GameDTO;
import com.goodgame.service.GameService;

@RestController
public class TrashGameApi {
	
	@Autowired
	GameService gameService;
	
	@PostMapping("api/game/trash")
	public GameDTO restoreGame(@RequestBody long ids) {
		return gameService.restore(ids);
	}
	
	@DeleteMapping("/api/game/trash")
	public void deleteGame(@RequestBody long[] ids) {
		gameService.deleteTrash(ids);
	}
}
