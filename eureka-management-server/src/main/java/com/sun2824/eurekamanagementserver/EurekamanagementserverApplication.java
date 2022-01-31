package com.sun2824.eurekamanagementserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekamanagementserverApplication {

    //유레카 클라이언트 관리하는 서버 어플리케이션
    
    public static void main(String[] args) {
        SpringApplication.run(EurekamanagementserverApplication.class, args);
    }

}
