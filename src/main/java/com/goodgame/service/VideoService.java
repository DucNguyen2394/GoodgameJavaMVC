package com.goodgame.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.goodgame.dto.VideoDTO;

public interface VideoService {
	
	List<VideoDTO> findAll(Pageable pageable);
	
	int getTotalItem();
	
	VideoDTO findById(long id);
	
	VideoDTO save(VideoDTO videoDTO);
	
	void delete(long[] ids);
	
	List<VideoDTO> findTrash();
}
