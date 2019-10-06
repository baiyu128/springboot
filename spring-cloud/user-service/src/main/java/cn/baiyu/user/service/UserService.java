package cn.baiyu.user.service;

import cn.baiyu.user.dao.UserDao;
import cn.baiyu.user.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @auther baiyu
 * @date 2019/10/6
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public User queryById(Long id){
        Optional<User> user = userDao.findById(id);
        try {
            return user.orElseThrow(()->new Exception("查无此人"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
