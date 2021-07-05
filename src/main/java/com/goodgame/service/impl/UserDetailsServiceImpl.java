package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.goodgame.constant.SystemConstant;
import com.goodgame.entity.RoleEntity;
import com.goodgame.entity.UserEntity;
import com.goodgame.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUsernameAndStatus(username,SystemConstant.ACTIVE_STATUS);
		if(userEntity == null) {
			throw new UsernameNotFoundException("User not found!!!");
		}
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for(RoleEntity role : userEntity.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		
		User user = new User(userEntity.getUsername(),userEntity.getPassword(), grantedAuthorities);
		
		return user;
	}

}
