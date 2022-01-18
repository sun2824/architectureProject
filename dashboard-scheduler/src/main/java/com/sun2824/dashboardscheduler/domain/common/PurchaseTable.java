package com.sun2824.dashboardscheduler.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Data
public class PurchaseTable {
    @Id
    String uuid;

    @Column
    String customerId;

    @Column
    Integer price;

    @Column
    String createdAt;
}
