package com.sun2824.dashboardscheduler.model.dto;

import lombok.Data;


@Data
public class PurchaseTableDTO {
    String uuid;

    String customerId;

    String priceGroup;

    String createdAt;

    Long cnt;

    Integer price;
}
