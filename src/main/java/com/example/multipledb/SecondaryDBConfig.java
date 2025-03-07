package com.example.multipledb;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
	    basePackages = "com.example.multipledb.secondary",
	    entityManagerFactoryRef = "secondaryEntityManagerFactory",
	    transactionManagerRef = "secondaryTransactionManager"
	)
public class SecondaryDBConfig {
	    @Bean(name = "secondaryDataSource")
	    @ConfigurationProperties(prefix = "spring.datasource.secondary")
	    DataSource secondaryDataSource() {
	        return DataSourceBuilder.create().build();
	    }
	    @Bean(name = "secondaryEntityManagerFactory")
	    LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("secondaryDataSource") DataSource dataSource) {
	        return builder
	                .dataSource(dataSource)
	                .packages("com.example.multipledb.secondary")
	                .persistenceUnit("abc2")
	                .build();
	    }
	    @Bean(name = "secondaryTransactionManager")
	    PlatformTransactionManager secondaryTransactionManager(
	            @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }
}
