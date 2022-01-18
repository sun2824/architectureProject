package com.sun2824.dashboardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class DashboardserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardserviceApplication.class, args);
    }

}
