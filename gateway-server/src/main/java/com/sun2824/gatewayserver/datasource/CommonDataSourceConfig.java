package com.sun2824.gatewayserver.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "commonEntityManagerFactory",
        transactionManagerRef = "commonTransactionManager",
        basePackages = "com.sun2824.gatewayserver.repository.common"
)
public class CommonDataSourceConfig {

    @Autowired
    @Qualifier("commonDataSource")
    DataSource commonDataSource;

    @Primary
    @Bean(name = "commonEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean commonEntityManagerFactory(EntityManagerFactoryBuilder builder){

        return builder
                .dataSource(commonDataSource)
                .packages("com.sun2824.gatewayserver.domain")
                .persistenceUnit("common")
                .build();
    }

    @Primary
    @Bean(name = "commonTransactionManager")
    public PlatformTransactionManager commonTransactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(commonEntityManagerFactory(builder).getObject());
    }
}
