package com.goodgame.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class GameEntity extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content" , columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "thumbnail")
	private String thumbnail;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "game_category", 
			joinColumns = @JoinColumn(name = "gameId"), 
			inverseJoinColumns = @JoinColumn(name = "categoryId")
			)
	private Set<CategoryEntity> categories = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="platform_id")
	private PlatformEntity platform;
	
	@OneToMany(mappedBy = "game")
	private List<VideoEntity> videos = new ArrayList<>();
	
	@Column(name = "status")
	private int status;
	
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
	
	public PlatformEntity getPlatform() {
		return platform;
	}
	public void setPlatform(PlatformEntity platform) {
		this.platform = platform;
	}

	 public Set<CategoryEntity> getCategories() { return categories; } public void
	 setCategories(Set<CategoryEntity> categories) { this.categories = categories;
	 }
	 
	public List<VideoEntity> getVideos() {
		return videos;
	}
	public void setVideos(List<VideoEntity> videos) {
		this.videos = videos;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
