package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.goodgame.converter.RoleConverter;
import com.goodgame.dto.RoleDTO;
import com.goodgame.entity.RoleEntity;
import com.goodgame.repository.RoleRepository;
import com.goodgame.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleConverter roleConverter;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> dtos = new ArrayList<>();
		List<RoleEntity> entities = roleRepository.findAll(); 
		for(RoleEntity entity : entities) {
			RoleDTO roleDTO = roleConverter.toDto(entity);
			dtos.add(roleDTO);
		}
		return dtos;
	}
	
}
