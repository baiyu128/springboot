package cn.baiyu.consumer.controller;

import cn.baiyu.consumer.client.UserClient;
import cn.baiyu.consumer.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cf")
public class ConsumerFeignController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        return userClient.queryById(id);
    }


    @PostMapping("list")
    public List<User> getAllUser() {
        return userClient.getAllUser();
    }
}
