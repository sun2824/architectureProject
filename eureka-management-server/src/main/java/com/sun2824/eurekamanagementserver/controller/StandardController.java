package com.sun2824.eurekamanagementserver.controller;

import com.sun2824.eurekamanagementserver.config.ApplicationContextProvider;
import com.sun2824.eurekamanagementserver.service.IStandardService;
import com.sun2824.eurekamanagementserver.service.StandardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1")
public class StandardController{

    private ApplicationContext context;
    StandardController(ApplicationContext context) { this.context = ApplicationContextProvider.getApplicationContext(); }

    @Autowired
    private StandardService standardService;

    @RequestMapping(value="/{serviceName}/{method}")
    public String common(@PathVariable String serviceName, @PathVariable String method){

        standardService.setService(context.getBean(serviceName+"Service", IStandardService.class));

        switch(method){
            case "data" : { standardService.data(); }
            case "update" : { standardService.update(); }
        }

        return serviceName;
    }
}