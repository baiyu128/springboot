package cn.baiyu.shrio.dao;

import cn.baiyu.shrio.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * @auther baiyu
 * @date 2019/10/2
 */
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User>, Serializable {

    @Query(value = "select * from shiro_user where is_deleted=0", nativeQuery = true)
    List<User> getAll();

    @Query(value = "select * from shiro_user where username=?1 and is_deleted=0", nativeQuery = true)
    User findByUsername(String userName);

    @Transactional
    @Modifying
    @Query(value = "update shiro_user set is_deleted=1 where id=?1", nativeQuery = true)
    void deleteUser(Integer id);
}
