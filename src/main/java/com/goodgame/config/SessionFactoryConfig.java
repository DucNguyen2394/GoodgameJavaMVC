//package com.goodgame.config;
//
//import java.io.IOException;
//import java.util.Properties;
//import javax.sql.DataSource;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate4.HibernateTransactionManager;
//import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
// 
//@Configuration
//public class SessionFactoryConfig {
//	
//	@Autowired
//	Environment env;
//	
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getProperty("com.mysql.cj.jdbc.Driver"));
//		dataSource.setUrl(env.getProperty("jdbc:mysql://localhost:3306/demo"));
//		dataSource.setUsername(env.getProperty("root"));
//		dataSource.setPassword(env.getProperty("ducnguyen@94"));
//		return dataSource;
//	}
//	
//	@Bean
//	@Autowired
//	public SessionFactory getSessionFactory(DataSource dataSource) throws IOException {
//		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//		
//		factoryBean.setPackagesToScan(new String[] {"com.goodgame.entity"});
//		factoryBean.setDataSource(dataSource);
//		Properties prop = factoryBean.getHibernateProperties();
//		prop.put("hibernate.dialect",env.getProperty("hb.dialect"));
//		prop.put("hibernate.show_sql", env.getProperty("hb.show_sql"));
//		prop.put("current_session_context_class", env.getProperty("hb.session"));
//		factoryBean.afterPropertiesSet();
//		SessionFactory sessionFactory = factoryBean.getObject();
//		return sessionFactory;
//	}
//	
//	@Bean
//	@Autowired
//	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
//		return new HibernateTransactionManager(sessionFactory);
//	}
//}