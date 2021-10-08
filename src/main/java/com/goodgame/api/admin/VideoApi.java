package com.goodgame.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodgame.dto.VideoDTO;
import com.goodgame.service.VideoService;

@RestController
public class VideoApi {
	
	@Autowired
	VideoService videoService;
	
	@PostMapping("api/video")
	public VideoDTO createVideo(@RequestBody VideoDTO videoDTO) {
		return videoService.save(videoDTO);
	}
	
	@PutMapping("api/video")
	public VideoDTO editVideo(@RequestBody VideoDTO videoDTO) {
		return videoService.save(videoDTO);
	}
	
	@DeleteMapping("api/video")
	public void deleteVideo(@RequestBody long[] ids) {
		videoService.delete(ids);
	}
}
