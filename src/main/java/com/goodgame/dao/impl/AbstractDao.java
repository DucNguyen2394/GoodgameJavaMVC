package com.goodgame.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.goodgame.dao.GenericDao;
import com.goodgame.mapper.RowMapper;

public class AbstractDao<T> implements GenericDao<T> {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/goodgame";
			String user = "root";
			String password = "ducnguyen@94";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	
	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... params) {
		return null;
	}

}
