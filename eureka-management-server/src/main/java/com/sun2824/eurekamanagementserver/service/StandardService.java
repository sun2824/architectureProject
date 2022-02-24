package com.sun2824.eurekamanagementserver.service;

import org.springframework.stereotype.Service;

@Service
public class StandardService {

    private IStandardService standardService;

    public StandardService setService(IStandardService standardService){
        this.standardService = standardService;
        return this;
    }

    public String data(){ return standardService.data(); }

    public String update(){ return standardService.update(); }
}
