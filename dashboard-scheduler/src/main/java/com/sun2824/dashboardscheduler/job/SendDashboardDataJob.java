package com.sun2824.dashboardscheduler.job;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun2824.dashboardscheduler.kafka.KafkaProducer;
import com.sun2824.dashboardscheduler.repository.common.DashboardDataRepository;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SendDashboardDataJob extends QuartzJobBean {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private DashboardDataRepository dashboardDataRepository;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        JsonArray jsonArray = new JsonArray();

        jsonArray.add(dashboardDataRepository.weekCustomerInfo());

        jsonArray.add(dashboardDataRepository.dailyCustomerGrade());

        jsonArray.add(dashboardDataRepository.dailyGradePurchasePrice());

        kafkaProducer.sendMessage(jsonArray.toString());
    }
}
