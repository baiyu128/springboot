package com.baiyu.demodocker.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class Name:
 *
 * @author yx
 * @description :
 * @date 2021/6/29
 */
@RestController
@RequestMapping
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "Hello,This Is Docker!";
    }
}
