package com.pengpenghuyu.supportplat.quartzdemo.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@DisallowConcurrentExecution
public class ScheduleTask implements Job {
    private static final Logger Logger = LoggerFactory.getLogger(ScheduleTask.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void quartzTest1() {
        Logger.info("====定时任务1 当前时间" + sdf.format(new Date()) + "====");
    }

    public void quartzTest2() {
        Logger.info("====定时任务2 当前时间" + sdf.format(new Date()) + "====");
    }

    public void quartzTest3() {
        Logger.info("====定时任务3 当前时间" + sdf.format(new Date()) + "====");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        quartzTest1();
        quartzTest2();
        quartzTest3();
    }
}
