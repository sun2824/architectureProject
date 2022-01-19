package com.sun2824.dashboardscheduler;

import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sun2824.dashboardscheduler.domain.common.QCustomerInfo;
import com.sun2824.dashboardscheduler.domain.common.QPurchaseTable;
import com.sun2824.dashboardscheduler.dto.common.CustomerInfoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
class DashboardschedulerApplicationTests {

    private EntityManager em;
    private JPAQueryFactory queryFactory;

    QCustomerInfo qCustomerInfo = QCustomerInfo.customerInfo;

    QPurchaseTable qPurchaseTable = QPurchaseTable.purchaseTable;

    @PersistenceContext(unitName = "common")
    public void setEntityManager(EntityManager entityManager) {
        em = entityManager;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Test
    void contextLoads() {
        List<CustomerInfoDTO> customerInfoDTOList = queryFactory
                .select(Projections.bean(CustomerInfoDTO.class,
                        qCustomerInfo.grade
                ))
                .from(qCustomerInfo)
                .where(Expressions.stringTemplate("DATE_FORMAT({0}, {1})", qCustomerInfo.createdAt, ConstantImpl.create("%Y-%m-%d")).eq(Expressions.stringTemplate("DATE_FORMAT({0}, {1})",qCustomerInfo.createdAt, ConstantImpl.create("%Y-%m-%d"))))
                .fetch();

        System.out.println(customerInfoDTOList);
    }

}
