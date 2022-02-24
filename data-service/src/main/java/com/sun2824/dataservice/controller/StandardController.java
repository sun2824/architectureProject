package com.sun2824.dataservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StandardController {

    @RequestMapping(value="/{sd}/{action}")
    public Object standardController(@PathVariable String sd, @PathVariable String action){
        
        System.out.println("sd : " + sd);
        System.out.println("action : " + action);

        return null;
    }
}
