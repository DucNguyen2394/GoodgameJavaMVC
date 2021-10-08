package com.goodgame.converter;

import org.springframework.stereotype.Component;

import com.goodgame.constant.SystemConstant;
import com.goodgame.dto.VideoDTO;
import com.goodgame.entity.VideoEntity;

@Component
public class VideoConverter {
	
	public VideoDTO toDto(VideoEntity videoEntity) {
		VideoDTO result = new VideoDTO();
		result.setId(videoEntity.getId());
		result.setName(videoEntity.getName());
		result.setEpisode(videoEntity.getEpisode());
		result.setLink(videoEntity.getLink());
		result.setThumbnail(videoEntity.getThumbnail());
		result.setGameName(videoEntity.getGame().getName());
		
		result.setStatus(SystemConstant.ACTIVE_STATUS);
		return result;
	}
	
	public VideoEntity toEntity(VideoDTO videoDTO) {
		VideoEntity result = new VideoEntity();
		result.setName(videoDTO.getName());
		result.setEpisode(videoDTO.getEpisode());
		result.setLink(videoDTO.getLink());
		result.setThumbnail(videoDTO.getThumbnail());
		
		result.setStatus(SystemConstant.ACTIVE_STATUS);
		return result;
	}
	
	public VideoEntity toEntity(VideoEntity result, VideoDTO videoDTO) {
		result.setName(videoDTO.getName());
		result.setEpisode(videoDTO.getEpisode());
		result.setLink(videoDTO.getLink());
		result.setThumbnail(videoDTO.getThumbnail());
		return result;
	}
}
