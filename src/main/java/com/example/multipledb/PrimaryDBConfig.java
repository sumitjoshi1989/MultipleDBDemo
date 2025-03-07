package com.example.multipledb;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	    basePackages = "com.example.multipledb.primary",
	    entityManagerFactoryRef = "primaryEntityManagerFactory",
	    transactionManagerRef = "primaryTransactionManager")
public class PrimaryDBConfig {
	    @Autowired
	    private Environment env;
	 
	    @Primary
	    @Bean(name = "primaryDataSource")
	    @ConfigurationProperties(prefix = "spring.datasource.primary")
	    DataSource primaryDataSource() {
	        return DataSourceBuilder.create().build();
	    }
	    
	    @Primary
	    @Bean(name = "primaryEntityManagerFactory")
	    LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("primaryDataSource") DataSource dataSource) {
	        return builder
	                .dataSource(dataSource)
	                .packages("com.example.multipledb.primary")
	                .persistenceUnit("abc1")
	                .build();
	    }
	    
	    @Primary
	    @Bean(name = "primaryTransactionManager")
	    PlatformTransactionManager primaryTransactionManager(
	            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }
}
