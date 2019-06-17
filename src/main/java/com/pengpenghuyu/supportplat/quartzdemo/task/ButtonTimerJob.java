package com.pengpenghuyu.supportplat.quartzdemo.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @DisallowConcurrentExecution : 此标记用在实现Job的类上面,意思是不允许并发执行.
 * 注org.quartz.threadPool.threadCount的数量有多个的情况,@DisallowConcurrentExecution才生效
 */
@DisallowConcurrentExecution
public class ButtonTimerJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(ButtonTimerJob.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 核心方法,Quartz Job真正的执行逻辑.
     *
     * @param context 中封装有Quartz运行所需要的所有信息
     * @throws JobExecutionException execute()方法只允许抛出JobExecutionException异常
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("--------------定时任务执行逻辑" + sdf.format(new Date()) + "---------------------");
    }
}
