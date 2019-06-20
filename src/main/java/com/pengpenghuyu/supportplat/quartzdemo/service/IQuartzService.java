package com.pengpenghuyu.supportplat.quartzdemo.service;

/***
 * @author wangyh
 * @date 2019/06/20
 */
public interface IQuartzService {

    /***
     * 新增任务(默认任务、定时器分组)
     * @param jobName 任务名称
     * @param jobClass 任务类
     * @param time cron 表达式
     */
    void addJob(String jobName, Class jobClass, String time);

    /***
     * 新增任务
     * @param jobName 任务名称
     * @param groupName 任务分组名称
     * @param triggerName 定时器名称
     * @param triggerGroupName 定时器分组名称
     * @param jobClass 任务类
     * @param time cron 表达式
     */
    void addJob(String jobName, String groupName, String triggerName, String triggerGroupName, Class jobClass, String time);

    /***
     * 修改时间(默认任务、定时器分组)
     * @param jobName 任务名称
     * @param time cron 表达式
     */
    void modifyJobTime(String jobName, String time);

    /***
     * 修改时间(默认任务、定时器分组)
     * @param triggerName 定时器名称
     * @param triggerGroupName 定时器分组名称
     * @param time cron 表达式
     */
    void modifyJobTime(String triggerName, String triggerGroupName, String time);

    /***
     * 删除任务(默认任务、定时器分组)
     * @param jobName 任务名称
     */
    void removeJob(String jobName);

    /***
     * 新增任务(默认任务、定时器分组)
     * @param jobName 任务名称
     * @param jobGroupName 任务组名称
     * @param triggerName 定时器名称
     * @param triggerGroupName 定时器分组名称
     */
    void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName);

    /***
     * 启动定时任务
     */
    void startJobs();

    /***
     * 停止定时任务
     */
    void shutdownJobs();
}
