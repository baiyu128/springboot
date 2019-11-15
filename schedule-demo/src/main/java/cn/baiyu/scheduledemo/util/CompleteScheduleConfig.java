package cn.baiyu.scheduledemo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * @author baiyu
 * @data 2019-11-15 11:16
 */
@Configuration
@EnableScheduling
@Slf4j
public class CompleteScheduleConfig implements SchedulingConfigurer, AsyncConfigurer {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Mapper
    public interface CronMapper {
        @Select("select cron from cron limit 1")
        String getCron();
    }

    @Autowired
    @SuppressWarnings("all")
    CronMapper cronMapper;

    /**
     * 执行定时任务.
     *
     * 动态从数据库获取配置的cron任务的执行周期，
     * 若需要修改可直接从数据库更改，而无需重启应用程序
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(taskScheduler);
        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> log.info("执行定时任务2: " + LocalDateTime.now().toLocalTime()+Thread.currentThread().getName()),
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronMapper.getCron();
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

}
