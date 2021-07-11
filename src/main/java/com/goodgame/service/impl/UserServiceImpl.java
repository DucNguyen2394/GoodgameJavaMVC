package com.goodgame.service.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
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
    
	@Override
	public void save(UserEntity user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new ArrayList<>(roleRepository.findAll()));
        userRepository.save(user);
	}
	
	@Override
	public UserEntity findByUsername(String username) {
	
		return null;
	}

}

