package com.sherif.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySources({
	@PropertySource("classpath:/sqlite.properties"),
	@PropertySource("classpath:/hibernateJpa.properties")
	})
public class DatabaseConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("app.datasource.driverClassName"));
		ds.setUrl(env.getProperty("app.datasource.url"));
		ds.setUsername(env.getProperty("app.datasource.username"));
		ds.setPassword(env.getProperty("app.datasource.password"));
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean  = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceUnitName("pUnit");
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		Map<String, Object> JpaPropertyMap = entityManagerFactoryBean.getJpaPropertyMap();
		JpaPropertyMap.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		JpaPropertyMap.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		JpaPropertyMap.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		JpaPropertyMap.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		return entityManagerFactoryBean;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		return vendorAdapter;
	}
	
	@Bean 
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
