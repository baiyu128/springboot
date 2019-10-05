package cn.baiyu.async.service;

import cn.baiyu.async.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * @auther baiyu
 * @date 2019/10/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootasyncApplicationTests {

    @Autowired
    private AsyncCallback task;

    @Autowired
    private AsyncTask asyncTask;
    @Autowired
    private SyncTask syncTask;
    @Test
    public void syncTaskTest() throws InterruptedException {
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();

    }
    @Test
    public void contextLoads() throws InterruptedException {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
        Thread.currentThread().join();
    }
    @Test
    public void AsyncTaskTest() throws InterruptedException, ExecutionException {
        Future<String> task1 = task.doTask();
        Future<String> task2 = task.doTask2();
        while(true){
            if(task1.isDone() && task2.isDone()){
                log.info("TASK1 result: {}",task1.get());
                log.info("TASK2 result: {}",task2.get());
                break;
            }
            Thread.sleep(1000);
        }
        log.info("All tasks finished.");
    }
}