package com.sun2824.dashboardservice.kafka;


import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class KafkaListener {
    SimpMessageSendingOperations messagingTemplate;

    @org.springframework.kafka.annotation.KafkaListener(topics = "dashboardData" , groupId = "test")
    public void dashboardDataMessage(String message){
        messagingTemplate.convertAndSend("/topic/dashboardData", message);
    }
}
