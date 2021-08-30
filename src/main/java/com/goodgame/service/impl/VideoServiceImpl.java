package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.goodgame.dto.VideoDTO;
import com.goodgame.entity.VideoEntity;
import com.goodgame.repository.VideoRepository;
import com.goodgame.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoRepository videoRepository;
	
	@Override
	public List<VideoDTO> findAll(Pageable pageable) {
		List<VideoDTO> model = new ArrayList<VideoDTO>();
		List<VideoEntity> videos = videoRepository.findAll(pageable).getContent();
		for(VideoEntity item : videos) {
			VideoDTO videoDTO = new VideoDTO();
			videoDTO.setName(item.getName());
			
			model.add(videoDTO);
		}
		return model;
	}

	@Override
	public int getTotalItem() {
		return (int) videoRepository.count();
	}

}
