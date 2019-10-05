package cn.baiyu.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 异步处理
 *
 * @auther baiyu
 * @date 2019/10/5
 */
@Slf4j
@Component
public class AsyncTask {

    public static Random random = new Random();
    @Async("taskExecutor")
    public void doTaskOne() throws InterruptedException {
        log.info("开始任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务一、耗时："+(end-start)+"毫秒");
    }
    @Async("taskExecutor")
    public void doTaskTwo() throws InterruptedException {
        log.info("开始任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务二、耗时："+(end-start)+"毫秒");
    }
    @Async("taskExecutor")
    public void doTaskThree() throws InterruptedException {
        log.info("开始任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务三、耗时："+(end-start)+"毫秒");
    }
}
