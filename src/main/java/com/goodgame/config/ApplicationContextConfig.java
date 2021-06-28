package com.goodgame.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.goodgame.*")
@EnableTransactionManagement
@PropertySource("classpath:datasource-cfg.properties")
public class ApplicationContextConfig {
	// Lưu trữ các giá thuộc tính load bởi @PropertySource.
	   @Autowired
	   private Environment env;
	
	@Bean(name = "dataSource")
	   public DataSource getDataSource() {
	       BasicDataSource dataSource = new BasicDataSource();
	  
	       // Xem: datasouce-cfg.properties
	       dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
	       dataSource.setUrl(env.getProperty("ds.url"));
	       dataSource.setUsername(env.getProperty("ds.username"));
	       dataSource.setPassword(env.getProperty("ds.password"));
	       System.out.println("## getDataSource: " + dataSource);
	       return dataSource;
	   }
	
	   @Autowired
	   @Bean(name = "sessionFactory")
	   public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
	       System.out.println("## getSessionFactory .... ");
	       try {
	           Properties properties = new Properties();
//	           properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	           // Xem: ds-hibernate-cfg.properties
	           properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	           properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	           properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
	 
	           LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	 
	           // Package contain entity classes
	           // Package chứa các entity class.
	           factoryBean.setPackagesToScan(new String[] { "com.goodgame.entity" });
	           factoryBean.setDataSource(dataSource);
	           factoryBean.setHibernateProperties(properties);
	           factoryBean.afterPropertiesSet();
	           //
	           SessionFactory sf = factoryBean.getObject();
	           System.out.println("## getSessionFactory: " + sf);
	           return sf;
	       } catch (Exception e) {
	           System.out.println("Error getSessionFactory: " + e);
	           e.printStackTrace();
	           throw e;
	       }
	   }
	   
	   // Hibernate Transaction Manager
	   @Autowired
	   @Bean(name = "transactionManager")
	   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	       HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	 
	       return transactionManager;
	   }
}
