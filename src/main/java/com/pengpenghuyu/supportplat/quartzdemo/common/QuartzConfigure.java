package com.pengpenghuyu.supportplat.quartzdemo.common;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import com.pengpenghuyu.supportplat.quartzdemo.task.ButtonTimerJob;
import com.pengpenghuyu.supportplat.quartzdemo.task.ScheduleTask;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


@Configuration
public class QuartzConfigure {
    // 配置文件路径
    private static final String QUARTZ_CONFIG = "/quartz.properties";

    @Autowired
    @Qualifier(value = "dataSource")
    private DataSource dataSource;

    @Autowired
    private JobFactory jobFactory;

    //每十秒
    private String tenSeconds = "10 */2 * * * ?";

    //每五秒
    private String fiveSeconds = "30 * * * * ?";

    /**
     * 从quartz.properties文件中读取Quartz配置属性
     * @return
     * @throws IOException
     */
    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource(QUARTZ_CONFIG));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    /**
     * JobFactory与schedulerFactoryBean中的JobFactory相互依赖,注意bean的名称
     * 在这里为JobFactory注入了Spring上下文
     *
     * @param context
     * @return
     */
//    @Bean
//    public JobFactory buttonJobFactory(ApplicationContext context) {
//        AutoWiredSpringBeanToJobFactory jobFactory = new AutoWiredSpringBeanToJobFactory();
//        jobFactory.setApplicationContext(context);
//        return jobFactory;
//    }

    /**
     *
     * @param buttonJobFactory  为SchedulerFactory配置JobFactory
     * @param cronJobTrigger
     * @return
     * @throws IOException
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory buttonJobFactory, Trigger... cronJobTrigger) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(jobFactory);
        factory.setOverwriteExistingJobs(true);
        factory.setQuartzProperties(quartzProperties());
        factory.setAutoStartup(true); // 设置自行启动
        factory.setTriggers(cronJobTrigger);
//        factory.setDataSource(dataSource);// 使用应用的dataSource替换quartz的dataSource
        return factory;
    }

    // 创建schedule
//    @Bean(name = "scheduler")
//    public Scheduler scheduler() throws IOException {
//        return schedulerFactoryBean().getScheduler();
//    }

    /**
     * 配置JobDetailFactory
     * JobDetailFactoryBean与CronTriggerFactoryBean相互依赖,注意bean的名称
     *
     * @return
     */
    @Bean(value = "firstDetail")
    public JobDetailFactoryBean firstDetail() {
        //集群模式下必须使用JobDetailFactoryBean，MethodInvokingJobDetailFactoryBean 类中的 methodInvoking 方法，是不支持序列化的
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setDurability(true);
        jobDetail.setRequestsRecovery(true);
        jobDetail.setJobClass(ButtonTimerJob.class);
        return jobDetail;
    }

    /**
     * 配置具体执行规则
     * @param firstDetail
     * @return
     */
    @Bean(value = "firstTrigger")
    public CronTriggerFactoryBean cronJobTrigger(JobDetail firstDetail) {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(firstDetail);
        tigger.setStartDelay(2000);   //延迟启动
        tigger.setCronExpression(tenSeconds);
        return tigger;
    }

    @Bean(value = "secondDetail")
    public JobDetailFactoryBean secondDetail() {
        //集群模式下必须使用JobDetailFactoryBean，MethodInvokingJobDetailFactoryBean 类中的 methodInvoking 方法，是不支持序列化的
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setDurability(true);
        jobDetail.setRequestsRecovery(true);
        jobDetail.setJobClass(ScheduleTask.class);
        return jobDetail;
    }

    /**
     * 配置具体执行规则
     * @param secondDetail
     * @return
     */
    @Bean(value = "secondTrigger")
    public CronTriggerFactoryBean secondTrigger(JobDetail secondDetail) {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(secondDetail);
        tigger.setStartDelay(2000);   //延迟启动
        tigger.setCronExpression(fiveSeconds);
        return tigger;
    }
}

