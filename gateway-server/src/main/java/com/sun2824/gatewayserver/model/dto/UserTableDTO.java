package com.sun2824.gatewayserver.model.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class UserTableDTO {

    String userId;

    String userName;

    String password;

    String email;

    Collection<? extends GrantedAuthority> authorities;
}
