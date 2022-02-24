package com.sun2824.eurekamanagementserver.service;

import org.springframework.stereotype.Service;

@Service
public class GameService implements IStandardService{
    @Override
    public String data(){
        return "a";
    }

    @Override
    public String update() {
        // TODO Auto-generated method stub
        return "gameUpdate";
    }
}
