//package com.goodgame.service;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.TypedQuery;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.goodgame.entity.GameEntity;
//
//@Component
//public class SomeService {
//
//  private SessionFactory factory;
//
//  @Autowired
//  public SomeService(EntityManagerFactory factory) {
//    if(factory.unwrap(SessionFactory.class) == null){
//      throw new NullPointerException("factory is not a hibernate factory");
//    }
//    this.factory = factory.unwrap(SessionFactory.class);
//  }
//  
//  public List<GameEntity> findByFavoriteId(String ids){
//	  String hql = "from GameEntity g "
//			  +"where g.id IN ("+ids+")";
//	  Session session = factory.getCurrentSession();
//	  Query query = session.createQuery(hql);
//	  
//	  List<GameEntity> list = query.getResultList();
//	  return list;
//  }
//
//}
