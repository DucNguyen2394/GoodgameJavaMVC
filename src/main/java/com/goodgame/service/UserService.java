package com.goodgame.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.goodgame.dto.UserDTO;
import com.goodgame.entity.UserEntity;

public interface UserService {
	
	List<UserDTO> findAll(Pageable pageable);
	
    UserDTO findByUsername(String username);
    
    UserDTO findById(long id);
    
    UserDTO save(UserDTO dto);
    
    void updateResetPasswordToken(String token, String email);
    
    UserEntity getByResetPasswordToken(String token);
    
    void updatePassword(UserEntity user, String newPassword);
    
    int getTotalItem();
    
    void delete(long[] ids);
        
    List<UserDTO> findTrash(Pageable pageable);
    
    void deleteTrash(long[] ids);
    
    UserDTO restore(long[] ids);
    
    UserDTO create(UserDTO dto);
}
