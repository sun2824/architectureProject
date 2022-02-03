package com.sun2824.dashboardscheduler.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Data
public class DashboardDataDTO implements Serializable {
    @Id
    String uuid;
    @Column
    String userId;
    @Column
    String deletedAt;
    @Column
    String userEml;
    @Column
    String userPwd;
}
