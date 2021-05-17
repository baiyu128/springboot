package cn.baiyu.consumer.client.fallback;

import cn.baiyu.consumer.client.UserClient;
import cn.baiyu.consumer.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户异常");
        return user;
    }

    @Override
    public String test() {
        return "test error";
    }

    @Override
    public List<User> getAllUser() {
        return new ArrayList<>();
    }
}
