package cn.baiyu.scheduledemo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author baiyu
 * @data 2019-10-28 16:24
 */
@Slf4j
@Component
@Async("taskExecutor")
public class ScheduleService {
    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
        log.info("=====>>>>>使用cron {}  {}",Thread.currentThread().getName(),System.currentTimeMillis());
    }
    /*@Scheduled(fixedRate = 5000)
    public void scheduled1() {
        log.info("=====>>>>>使用fixedRate{} {}",Thread.currentThread().getName(), System.currentTimeMillis());
    }
    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
        log.info("=====>>>>>fixedDelay{}{}",Thread.currentThread().getName(),System.currentTimeMillis());
    }*/
}
