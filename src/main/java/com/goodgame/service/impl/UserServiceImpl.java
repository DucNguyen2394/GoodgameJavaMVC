package com.goodgame.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.goodgame.constant.SystemConstant;
import com.goodgame.converter.UserConverter;
import com.goodgame.dto.UserDTO;
import com.goodgame.entity.RoleEntity;
import com.goodgame.entity.UserEntity;
import com.goodgame.repository.RoleRepository;
import com.goodgame.repository.UserRepository;
import com.goodgame.service.UserService;

@Service
@Transactional
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
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for(UserEntity entity : entities) {
			if(entity.getStatus() == SystemConstant.ACTIVE_STATUS) {
				UserDTO userDTO = userConverter.toDto(entity);
				dtos.add(userDTO);				
			}
		}
		return dtos;
	}
    
//	@Override
//	public void save(UserEntity user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new ArrayList<>(roleRepository.findAll()));
//        userRepository.save(user);
//	}
	
	@Override
	public UserDTO findByUsername(String username) {
		UserEntity userEntity = userRepository.findOneByUsername(username);
		return userConverter.toDto(userEntity);
	}

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
					
		UserEntity userEntity = new UserEntity();
		
		if(dto.getId() != null) {
			UserEntity oldUser = userRepository.findOne(dto.getId());

			for(String item : dto.getUserCode()) {
				RoleEntity roleEntity = roleRepository.findOneByCode(item);
				oldUser.getRoles().add(roleEntity);
			}

			userEntity = userConverter.toEntity(oldUser,dto);
			dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		}else {
			userEntity = userConverter.toEntity(dto);

			for(String item : dto.getUserCode()) {
				RoleEntity roleEntity = roleRepository.findOneByCode(item);
				userEntity.getRoles().add(roleEntity);					
			}
			
			dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		}
		return userConverter.toDto(userRepository.save(userEntity));

	}
	
	public void updateResetPasswordToken(String token, String email) {
        UserEntity userEntity = userRepository.findOneByEmail(email);
        if (userEntity != null) {
        	userEntity.setResetPasswordToken(token);
        	userRepository.save(userEntity);
        } else {
            System.err.println("Could not find any customer with the email ");
        }
    }
	
	public UserEntity getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

	public void updatePassword(UserEntity user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
         
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }

	@Override
	public int getTotalItem() {
		return (int) userRepository.count();
	}

	@Override
	public UserDTO findById(long id) {
		UserEntity userEntity = userRepository.findOne(id);
		return userConverter.toDto(userEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			UserEntity userEntity = userRepository.findOne(id);
			userEntity.setStatus(SystemConstant.INACTIVE_STATUS);
		}
	}

	@Override
	public List<UserDTO> findTrash(Pageable pageable) {
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for(UserEntity entity : entities) {
			if(entity.getStatus() == SystemConstant.INACTIVE_STATUS) {
				UserDTO userDTO = userConverter.toDto(entity);
				dtos.add(userDTO);				
			}
		}
		return dtos;
	}

	@Override
	public void deleteTrash(long[] ids) {
		for(long id : ids) {
			userRepository.delete(id);
		}
	}

	@Override
	public UserDTO restore(long[] ids) {
		UserEntity userEntity = new UserEntity();
		for(long id : ids) {
			userEntity = userRepository.findOne(id);			
			userEntity.setStatus(SystemConstant.ACTIVE_STATUS);
		}
		return userConverter.toDto(userRepository.save(userEntity));
	}

	@Override
	@Transactional
	public UserDTO create(UserDTO dto) {
		dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		UserEntity entity = userConverter.toEntity(dto);
		RoleEntity role = new RoleEntity();

		if(role.getCode() == null) {
			role = roleRepository.findOneByCode(("USER"));
			entity.getRoles().add(role);			
		}
		if(role.getCode().equalsIgnoreCase("ADMIN") && role.getId() == 1 && role.getName().equalsIgnoreCase("admin")) {
			return null;
		}
		return userConverter.toDto(userRepository.save(entity));
	}

}

