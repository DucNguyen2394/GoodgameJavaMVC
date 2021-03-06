package com.goodgame.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameDTO extends AbstractDTO<GameDTO> {
	
	private String name;
	private String title;
	private String content;
	private String description;
	private String thumbnail;
	private Long platformId;
	private String platformCode;
	private Long categoryId;
	private String categoryCode;
	private int status;
	
	private Long videoId;
	private List<VideoDTO> videos = new ArrayList<>();
	
	private Set<CategoryDTO> categories = new HashSet<>();;
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Long getPlatformId() {
		return platformId;
	}
	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getPlatformCode() {
		return platformCode;
	}
	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}
	
	 public Set<CategoryDTO> getCategories() { return categories; } 
	 public void setCategories(Set<CategoryDTO> categories) { this.categories = categories; }
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getVideoId() {
		return videoId;
	}
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
	public List<VideoDTO> getVideos() {
		return videos;
	}
	public void setVideos(List<VideoDTO> videos) {
		this.videos = videos;
	}
}
