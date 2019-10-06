package cn.baiyu.user.dao;

import cn.baiyu.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @auther baiyu
 * @date 2019/10/6
 */
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
