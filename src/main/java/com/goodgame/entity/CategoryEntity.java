package com.goodgame.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
	
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
	
//	@OneToMany(mappedBy = "category")
//	private List<GameEntity> games = new ArrayList<>();
//	
//	public List<GameEntity> getGames() {
//		return games;
//	}
//	public void setGames(List<GameEntity> games) {
//		this.games = games;
//	}
	
	@ManyToMany(mappedBy = "categories")
	private Set<GameEntity> games = new HashSet<>();;

	public Set<GameEntity> getGames() {
		return games;
	}
	public void setGames(Set<GameEntity> games) {
		this.games = games;
	}
	
}
