//package com.goodgame.service.impl;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.goodgame.entity.GameEntity;
//import com.goodgame.repository.GameRepository;
//
//@Service
//@Transactional
//public class SomeService {
//
//	@Autowired
//	GameRepository gameRepository;
//
//	
//	public List<GameEntity> findByInCriteria(String names){
//        return gameRepository.findAll(new Specification<GameEntity>() {
//			@Override
//			public Predicate toPredicate(Root<GameEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				List<Predicate> predicates = new ArrayList<>();
//				if(names!=null && !names.isEmpty()) {
//                    predicates.add(root.get("name").in(names));
//                }
//                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
//			}
//        });
//    }
//	
//	public Connection getConnection() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
//			String user = "root";
//			String PASSWORD = "ducnguyen@94";
//			return DriverManager.getConnection(url, user, PASSWORD);
//		}catch(Exception e) {
//			return null;
//		}
//	}
//	
//	public List<GameEntity> findByNameIn(String names){
//		List<GameEntity> result = new ArrayList<GameEntity>();
//		String sql = "select * from game where game.name IN ("+names+")";
//		System.err.println("SQL " + sql);
//		Connection connection = getConnection();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		if(connection != null) {
//			try {
//				ps = connection.prepareStatement(sql);
////				ps.setString(1, names);
//				rs = ps.executeQuery();
//				while(rs.next()) {
//					GameEntity game = new GameEntity();
//					game.setName(rs.getString("name"));
//					game.setCode(rs.getNString("code"));
//					result.add(game);
//				}
//				return result;
//			}catch (Exception e) {
//				return null;
//			}finally {
//				if(connection != null) {
//					try {
//						connection.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}if(ps != null) {
//					try {
//						ps.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}if(rs != null) {
//					try {
//						rs.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		return null;
//	}
//}
