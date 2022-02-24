package com.sun2824.dashboardscheduler.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer_info")
@Data
public class CustomerInfoEntity {
    @Id
    String customerId;
    @Column
    String grade;
    @Column
    String age;
    @Column
    String createdAt;
}
