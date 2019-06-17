package com.pengpenghuyu.supportplat.quartzdemo.service.impl;


import com.pengpenghuyu.supportplat.quartzdemo.service.IQuartzService;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

@Service
public class QuartzServiceImpl implements IQuartzService {

    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    @Override
    public void addJob(String jobName, Class jobClass, String time) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addJob(String jobName, String groupName, String triggerName, String triggerGroupName, Class jobClass, String time) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyJobTime(String jobName, String time) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyJobTime(String triggerName, String triggerGroupName, String time) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeJob(String jobName) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startJobs() {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void shutdownJobs() {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
