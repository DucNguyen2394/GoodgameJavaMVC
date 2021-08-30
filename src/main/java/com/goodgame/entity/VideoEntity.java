package com.goodgame.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class VideoEntity extends BaseEntity{
	
	private String name;
	
	private String link;
	
	private String episode; 
	
	private String thumbnail;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "game_id")
	private GameEntity game;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	public GameEntity getGame() {
		return game;
	}

	public void setGame(GameEntity game) {
		this.game = game;
	}
	
	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	
}
