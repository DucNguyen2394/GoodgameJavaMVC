package com.goodgame.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.goodgame.model.GameModel;

public class GameMapper implements RowMapper<GameModel> {

	@Override
	public GameModel mapRow(ResultSet rs) {
		try {
			GameModel games = new GameModel();
			games.setId(rs.getLong("id"));
			games.setName(rs.getString("name"));
			games.setTitle(rs.getString("title"));
			games.setContent(rs.getString("content"));
			games.setDescription(rs.getString("description"));
			games.setThumbnail(rs.getString("thumbnail"));
			games.setCategoryId(rs.getLong("categoryId"));
			games.setPlatformId(rs.getLong("platformId"));
//			games.setCreatedDate(rs.getTimestamp("createAt"));
//			games.setCreatedBy(rs.getString("createBy"));
//			if (rs.getTimestamp("modifiedAt") != null) {
//				games.setModifiedDate(rs.getTimestamp("modifiedAt"));
//			}
//			if (rs.getString("modifiedBy") != null) {
//				games.setModifiedBy(rs.getString("modifiedBy"));
//			}
			return games;
		} catch (SQLException e) {
			return null;
		}
	}

}
