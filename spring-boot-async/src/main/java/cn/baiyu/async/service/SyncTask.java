package cn.baiyu.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 同步消息
 *
 * @auther baiyu
 * @date 2019/10/5
 */
@Component
@Slf4j
public class SyncTask {

    public static Random random = new Random();
    public void doTaskOne() throws InterruptedException {
        log.info("sync开始任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("sync完成任务一、耗时："+(end-start)+"毫秒");
    }
    public void doTaskTwo() throws InterruptedException {
        log.info("sync开始任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("sync完成任务二、耗时："+(end-start)+"毫秒");
    }
    public void doTaskThree() throws InterruptedException {
        log.info("sync开始任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("sync完成任务三、耗时："+(end-start)+"毫秒");
    }

    public static void main(String[] args) throws InterruptedException {
        SyncTask syncTask = new SyncTask();
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }
}
