package com.goodgame.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {
	
	@Column(name ="code", nullable = false)
	private String code;
	
	@Column(name = "name",nullable = false, length = 10)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Set<UserEntity> users = new HashSet<>();

	public String getName() {
		return name;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
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
	
}
