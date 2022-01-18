package com.sun2824.dashboardscheduler.dto.common;

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
