package com.goodgame.dto;

import java.util.HashSet;
import java.util.Set;

public class CategoryDTO extends AbstractDTO<CategoryDTO> {
	
	private String name;
	private String code;
	
	private Set<GameDTO> games = new HashSet<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	 public Set<GameDTO> getGames() { return games; } 
	 public void setGames(Set<GameDTO> games) { this.games = games; }

}
