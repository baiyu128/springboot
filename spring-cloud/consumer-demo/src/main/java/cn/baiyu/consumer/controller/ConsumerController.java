package cn.baiyu.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @auther baiyu
 * @date 2019/10/6
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("{id}")
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "queryByIdFallback")
    public String queryById(@PathVariable("id") Long id) {
        String url = "http://localhost:8091/user/" + id;

        //获取eureka中注册的user-service实例列表
        /*ServiceInstance serviceInstance = discoveryClient.getInstances("user-service").get(0);

        url = "http://" + serviceInstance.getHost()+ ":" + serviceInstance.getPort() + "/user/" + id;*/

        url = "http://user-service/user/" + id;

        return restTemplate.getForObject(url, String.class);
    }

    public String queryByIdFallback(Long id) {
        log.error("查询用户信息失败。id：{}", id);
        return "对不起，网络太拥挤了！";
    }

    public String defaultFallback() {
        return "默认提示：对不起，网络太拥挤了！";
    }
}
