package com.sun2824.dashboardscheduler.repository.common;

import com.sun2824.dashboardscheduler.domain.common.DashboardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardDataRepository extends JpaRepository<DashboardData, String> {
}
