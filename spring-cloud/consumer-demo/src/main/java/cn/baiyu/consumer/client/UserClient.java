package cn.baiyu.consumer.client;

import cn.baiyu.consumer.client.fallback.UserClientFallback;
import cn.baiyu.consumer.config.FeignConfig;
import cn.baiyu.consumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//声明当前类是一个Feign客户端，指定服务名为user-service
@FeignClient(value = "user-service", fallback = UserClientFallback.class,
configuration = FeignConfig.class)
public interface UserClient {

    //http://user-service/user/123
    @GetMapping("/user/{id}")
    User queryById(@PathVariable Long id);

    @GetMapping("/user/test")
    String test();
}
