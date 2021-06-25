package com.goodgame.dao;

import java.util.List;
import com.goodgame.mapper.RowMapper;

public interface GenericDao<T> {
	List<T> query(String sql, RowMapper<T> rowMapper, Object... params);
}
