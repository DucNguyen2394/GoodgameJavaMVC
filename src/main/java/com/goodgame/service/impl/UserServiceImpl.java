package com.goodgame.service.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.goodgame.converter.UserConverter;
import com.goodgame.dto.UserDTO;
import com.goodgame.entity.UserEntity;
import com.goodgame.repository.RoleRepository;
import com.goodgame.repository.UserRepository;
import com.goodgame.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserConverter userConverter;
    
	@Override
	public void save(UserEntity user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new ArrayList<>(roleRepository.findAll()));
        userRepository.save(user);
	}
	
	@Override
	public UserDTO findByUsername(String username) {
		UserEntity userDTO = userRepository.findOneByUsername(username);
		return userConverter.toDto(userDTO);
	}

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		UserEntity userEntity = new UserEntity();
		dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		userEntity = userConverter.toEntity(dto);
		return userConverter.toDto(userRepository.save(userEntity));
	}

}

