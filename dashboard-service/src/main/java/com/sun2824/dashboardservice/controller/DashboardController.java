package com.sun2824.dashboardservice.controller;

import com.sun2824.dashboardservice.queue.KafkaQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    private KafkaQueue kafkaQueue;

    @PostMapping("getDashboardDatas")
    public void getDashboardDatas(){
        kafkaQueue = KafkaQueue.getInstance("dashboardDatas");

        String message = kafkaQueue.kafkaQueue.peek() == null ? "" : kafkaQueue.kafkaQueue.peek().toString();

        if(message!=null && !message.equals("null") && !message.equals("")){
            messagingTemplate.convertAndSend("/topic/dashboardDatas", message);
        }

    }
}
