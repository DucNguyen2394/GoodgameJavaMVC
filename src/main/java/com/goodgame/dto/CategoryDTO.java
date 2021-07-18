package com.goodgame.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO extends AbstractDTO<CategoryDTO> {
	
	private String name;
	private String code;
	
	private List<GameDTO> games = new ArrayList<>();
	
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
	public List<GameDTO> getGames() {
		return games;
	}
	public void setGames(List<GameDTO> games) {
		this.games = games;
	}
}
