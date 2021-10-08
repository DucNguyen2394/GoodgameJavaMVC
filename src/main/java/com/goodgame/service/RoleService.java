package com.goodgame.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.goodgame.dto.RoleDTO;

public interface RoleService {
	List<RoleDTO> findAll();
	
	Map<String, String> find();
	
	Set<String> findSet();
}
