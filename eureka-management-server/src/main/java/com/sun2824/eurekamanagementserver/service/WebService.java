package com.sun2824.eurekamanagementserver.service;

import org.springframework.stereotype.Service;

@Service
public class WebService implements IStandardService {

    @Override
    public String data() {
        // TODO Auto-generated method stub
        return "web";
    }

    @Override
    public String update() {
        // TODO Auto-generated method stub
        return "webUpdate";
    }
    
}
