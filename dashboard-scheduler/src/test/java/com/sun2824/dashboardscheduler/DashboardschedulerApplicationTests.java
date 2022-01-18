package com.sun2824.dashboardscheduler;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sun2824.dashboardscheduler.domain.common.QTopologyMng;
import com.sun2824.dashboardscheduler.domain.common.TopologyMng;
import kafka.KafkaTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
class DashboardschedulerApplicationTests {

    QTopologyMng qTopologyMng = QTopologyMng.topologyMng;

    private EntityManager em;
    private JPAQueryFactory queryFactory;

    @PersistenceContext(unitName = "common")
    public void setEntityManager(EntityManager entityManager) {
        em = entityManager;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Test
    void contextLoads() {
        System.out.println(" -- list : "+queryFactory.select(Projections.bean(TopologyMng.class,
                qTopologyMng.mngDbNm)
        ).from(qTopologyMng).fetch());

    }

}
