package cn.baiyu.user.controller;

import cn.baiyu.user.entity.User;
import cn.baiyu.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther baiyu
 * @date 2019/10/6
 */
@RestController
@RequestMapping("/user")
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

    @GetMapping("/test")
    public String test() {
        System.out.println("Test");
        return "test";
    }
}
