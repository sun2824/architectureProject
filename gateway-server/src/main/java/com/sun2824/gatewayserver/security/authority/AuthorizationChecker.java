package com.sun2824.gatewayserver.security.authority;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthorizationChecker {
    public boolean check(HttpServletRequest request, Authentication authentication){

        return true;
    }
}
