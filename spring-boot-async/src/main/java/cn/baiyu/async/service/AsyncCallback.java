package cn.baiyu.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @auther baiyu
 * @date 2019/10/5
 */
@Component
@Slf4j
public class AsyncCallback {

    @Async("taskExecutor")
    public Future<String> doTask() throws InterruptedException {
        log.info("Task1 started");
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        long end = System.currentTimeMillis();
        log.info("Task1 finished,time elapsed:{} ms",end-start);
        return new AsyncResult<>("Task1 accomplished");
    }
    @Async("taskExecutor")
    public Future<String> doTask2() throws InterruptedException {
        log.info("Task2 started");
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        log.info("Task2 finished,time elapsed:{} ms",end-start);
        return new AsyncResult<>("Task2 accomplished");
    }
}
