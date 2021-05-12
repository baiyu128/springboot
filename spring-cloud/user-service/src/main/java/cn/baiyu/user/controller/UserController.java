package cn.baiyu.user.controller;

import cn.baiyu.user.entity.User;
import cn.baiyu.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther baiyu
 * @date 2019/10/6
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @Value("${test.name}")
    private String name;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        System.out.println("配置文件中的test.name = " + name);
        return userService.queryById(id);
    }

    @PostMapping("/list")
    public List<User> getAllUser() {
        log.info("查询所有用户");
        return userService.getAllUser();
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("Test");
        return "test";
    }
}
