package cn.baiyu.springboot.advice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * class Name:
 *
 * @author yx
 * @description :
 * @date 2021/5/31
 */
@Component
public class RunService implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        new Thread(() -> {
            int i = 0;
            while (true) {
                i++;
                try {
                    Thread.sleep(1000);
                    System.out.println("过去了10s，i的值为：" +i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 4) {
                    throw new RuntimeException();
                }
                continue;
            }
        }).start();
    }
}
