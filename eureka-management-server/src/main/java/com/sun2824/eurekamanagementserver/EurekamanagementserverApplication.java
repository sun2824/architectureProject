package com.sun2824.eurekamanagementserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekamanagementserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekamanagementserverApplication.class, args);
    }

}
