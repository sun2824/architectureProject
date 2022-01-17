package com.sun2824.dashboardscheduler;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class kafkaTest {

    @KafkaListener(topics = "kms-topic" , groupId = "test")
    public void consume(String message) throws IOException {
        System.out.println(message);
    }

}
