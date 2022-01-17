package com.sun2824.dashboardscheduler.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Data
public class DashboardData implements Serializable {
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
