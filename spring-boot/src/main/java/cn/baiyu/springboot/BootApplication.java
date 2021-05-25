package cn.baiyu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * class Name:
 *
 * @author yx
 * @description :
 * @date 2021/5/25
 */
@Configuration
@SpringBootApplication()
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
