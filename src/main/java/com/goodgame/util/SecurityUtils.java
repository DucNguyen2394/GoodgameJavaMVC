package com.goodgame.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;


public class SecurityUtils {
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities(){
		List<String> result = new ArrayList<String>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority authority : authorities) {
			result.add(authority.getAuthority());
		}
		return result;
	}
	
	public static User getPrincipal() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}
}
