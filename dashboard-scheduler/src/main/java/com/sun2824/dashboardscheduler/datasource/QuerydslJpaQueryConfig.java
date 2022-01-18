package com.sun2824.dashboardscheduler.datasource;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QuerydslJpaQueryConfig {

    @PersistenceContext(unitName = "commonEntityManagerFactory")
    private EntityManager em;

    @Bean(name = "commonJPAQueryFactory")
    public JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(em);
    }
}
