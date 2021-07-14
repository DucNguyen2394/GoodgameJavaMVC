package com.goodgame.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO extends AbstractDTO<RoleDTO> {
	private String name;
	private String code;
	
	private List<UserDTO> user = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<UserDTO> getUser() {
		return user;
	}
	public void setUser(List<UserDTO> user) {
		this.user = user;
	}
	
	
}
