package cn.baiyu.scheduledemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;

/**
 * @author baiyu
 * @data 2019-10-28 16:25
 */
@Configuration
@Slf4j
@EnableAsync
public class AsyncConfig {

    /*
    此处成员变量应该使用@Value从配置中读取
     */
    @Value("${my.config.corePoolSize}")
    private int corePoolSize;
    @Value("${my.config.maxPoolSize}")
    private int maxPoolSize;
    @Value("${my.config.queueCapacity}")
    private int queueCapacity;
    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        log.info(""+corePoolSize);
        log.info(""+maxPoolSize);
        log.info(""+queueCapacity);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }

    @Bean(destroyMethod="shutdown")
    public ThreadPoolTaskScheduler taskScheduler()
    {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(maxPoolSize);
        scheduler.setThreadNamePrefix("task-");
        scheduler.setAwaitTerminationSeconds(60);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        return scheduler;
    }
}
