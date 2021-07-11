package com.goodgame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="category_id")
	private CategoryEntity category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="platform_id")
	private PlatformEntity platform;
	
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
	public CategoryEntity getCategoryEntity() {
		return category;
	}
	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.category = categoryEntity;
	}
	public PlatformEntity getPlatform() {
		return platform;
	}
	public void setPlatform(PlatformEntity platform) {
		this.platform = platform;
	}
	
	
}
