package com.goodgame.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="platform")
public class PlatformEntity extends BaseEntity {
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;

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
	
	@OneToMany(mappedBy = "platform")
	private List<GameEntity> games = new ArrayList<>();

	public List<GameEntity> getGames() {
		return games;
	}

	public void setGames(List<GameEntity> games) {
		this.games = games;
	}
	
}
