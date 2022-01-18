package com.sun2824.dashboardscheduler.repository.common;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun2824.dashboardscheduler.domain.common.CustomerInfo;

import java.util.List;
import java.util.Map;

public interface DashboardDataRepositoryCustom {

    JsonObject weekCustomerInfo();

    JsonArray dailyCustomerGrade();

    JsonArray dailyGradePurchasePrice();

}
