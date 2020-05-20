package com.baiyu.resource.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baiyu
 * @data 2020-05-20 9:43
 */
@RestController("/api")
public class HelloController {

    @PostMapping("/api/hi")
    public String say(String name) {
        return "hi , " + name;
    }

}
