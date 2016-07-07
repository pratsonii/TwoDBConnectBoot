package com.example;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory2", 
        basePackages = { "com.example.tb2.repo" })
public class User2Config {

	
	@Bean(name = "ds2")
	@ConfigurationProperties(prefix="spring.ds2")
	public DataSource dataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	 
	    @Bean(name = "entityManagerFactory2")
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
	            EntityManagerFactoryBuilder builder,
	            @Qualifier("ds2") DataSource dataSource) {
	        return builder
	                .dataSource(dataSource)
	                .packages("com.example.tb2.model")
	                .persistenceUnit("foo2")
	                .build();
	    }

	    
	    @Bean(name = "transactionManager2")
	    public PlatformTransactionManager transactionManager(
	            @Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }
}
