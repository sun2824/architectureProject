package com.sun2824.dashboardscheduler;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sun2824.dashboardscheduler.domain.common.QCustomerInfo;
import com.sun2824.dashboardscheduler.domain.common.QPurchaseTable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.UUID;

@Service
public class kafkaTest {

    @KafkaListener(topics = "dashboardData" , groupId = "test")
    public void consume(String message) throws IOException {
        System.out.println(message);
    }

}
