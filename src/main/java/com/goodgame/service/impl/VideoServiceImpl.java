package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goodgame.constant.SystemConstant;
import com.goodgame.converter.VideoConverter;
import com.goodgame.dto.VideoDTO;
import com.goodgame.entity.GameEntity;
import com.goodgame.entity.VideoEntity;
import com.goodgame.repository.GameRepository;
import com.goodgame.repository.VideoRepository;
import com.goodgame.service.VideoService;

@Service
@Transactional
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoRepository videoRepository;
	
	@Autowired
	private VideoConverter videoConverter;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public List<VideoDTO> findAll(Pageable pageable) {
		List<VideoDTO> model = new ArrayList<VideoDTO>();
		List<VideoEntity> videos = videoRepository.findAll(pageable).getContent();
		for(VideoEntity item : videos) {
			if(item.getStatus() == SystemConstant.ACTIVE_STATUS) {
				VideoDTO videoDTO = videoConverter.toDto(item);		
				model.add(videoDTO);
			}
		}
		return model;
	}

	@Override
	public int getTotalItem() {
		return (int) videoRepository.count();
	}

	@Override
	public VideoDTO findById(long id) {
		VideoEntity videoEntity = videoRepository.findOne(id);
		return videoConverter.toDto(videoEntity);
	}

	@Override
	public VideoDTO save(VideoDTO videoDTO) {
		GameEntity gameEntity = gameRepository.findOneByName(videoDTO.getGameName());
		VideoEntity videoEntity = new VideoEntity();
		if(videoDTO.getId() != null) {
			VideoEntity oldVideo = videoRepository.findOne(videoDTO.getId());
			oldVideo.setGame(gameEntity);
			videoEntity = videoConverter.toEntity(oldVideo, videoDTO);
		}else {
			videoEntity = videoConverter.toEntity(videoDTO);
			videoEntity.setGame(gameEntity);
			
		}
	
		return videoConverter.toDto(videoRepository.save(videoEntity));
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			VideoEntity videoEntity = videoRepository.findOne(id);
			videoEntity.setStatus(SystemConstant.INACTIVE_STATUS);
			videoRepository.save(videoEntity);
		}
	}

	@Override
	public List<VideoDTO> findTrash() {
		List<VideoDTO> dtos = new ArrayList<>();
		List<VideoEntity> entities = videoRepository.findAll();
		for(VideoEntity entity : entities) {
			if(entity.getStatus() == SystemConstant.INACTIVE_STATUS) {
				VideoDTO videoDTO = videoConverter.toDto(entity);
				
				dtos.add(videoDTO);
			}
		}
		
		return dtos;
	}
	
	
}
