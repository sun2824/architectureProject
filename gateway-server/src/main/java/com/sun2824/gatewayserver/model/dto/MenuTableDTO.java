package com.sun2824.gatewayserver.model.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class MenuTableDTO {
    String fullPath;

    String parentPath;

    String childPath;

    String authorities;
}
