package com.goodgame.dto;

public class VideoDTO extends AbstractDTO<VideoDTO>{
	
	private String name;
	
	private String link;
	
	private String episode; 
	
	private String thumbnail;
	
	private GameDTO gameDTO;

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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public GameDTO getGameDTO() {
		return gameDTO;
	}

	public void setGameDTO(GameDTO gameDTO) {
		this.gameDTO = gameDTO;
	}
}
