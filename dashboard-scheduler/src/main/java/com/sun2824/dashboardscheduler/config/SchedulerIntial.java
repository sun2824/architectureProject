package com.sun2824.dashboardscheduler.config;

import com.sun2824.dashboardscheduler.job.SendDashboardDataJob;
import lombok.AllArgsConstructor;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Configuration
public class SchedulerIntial {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    void start(){
        try{
            scheduler.scheduleJob(buildJobTrigger("dashboardScheduler", "10 * * * * ?"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public Trigger buildJobTrigger(String triggerKey, String cronTriggerFormat){
        return TriggerBuilder.newTrigger()
                .withIdentity(triggerKey, "dashboardJobGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronTriggerFormat)).build();
    }

    public JobDetail buildJobDetail(){
        return JobBuilder.newJob(SendDashboardDataJob.class)
                .withIdentity("dashboardJob", "dashboardJobGroup")
                .build();
    }
}
