package com.sun2824.dashboardscheduler.datasource;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QuerydslJpaQueryConfig {

    @PersistenceContext(unitName = "allviewsEntityManagerFactory")
    private EntityManager em;

    @Bean(name = "allviewsJPAQueryFactory")
    public JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(em);
    }
}
