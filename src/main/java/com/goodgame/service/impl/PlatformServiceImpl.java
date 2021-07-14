package com.goodgame.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodgame.converter.PlatformConverter;
import com.goodgame.entity.PlatformEntity;
import com.goodgame.repository.PlatformRepository;
import com.goodgame.service.PlatformService;

@Service
public class PlatformServiceImpl implements PlatformService {
	
	@Autowired
	PlatformRepository platformRepository;
	
	@Autowired
	PlatformConverter platformConverter;
	
	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<PlatformEntity> entities = platformRepository.findAll();
		for(PlatformEntity items : entities) {
			result.put(items.getCode(), items.getName());
		}
		return result;
	}

}
