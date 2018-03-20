package com.lpc.springboot.weather.config;

import com.lpc.springboot.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz配置
 */
@Configuration
public class QuartzConfiguration {

//    更新频率
    private static final int TIME = 1800;

    //JobDetail  => JOB
    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJobDetail")
                .storeDurably().build();
    }

    // Trigger  => 触发
    @Bean
    public Trigger weatherDataSyncTriger(){
//        创建调度时间配置
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();
//        创建并返回Trigger
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTriger")
                .withSchedule(scheduleBuilder).build();
    }
}
