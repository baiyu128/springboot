package cn.baiyu.client.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @auther baiyu
 * @date 2019/10/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CityDubboConsumerServiceTest {

    @Autowired
    private CityDubboConsumerService cityDubboConsumerService;

    @Test
    public void testD(){
        cityDubboConsumerService.printCity();
    }
}