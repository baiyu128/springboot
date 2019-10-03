package cn.baiyu.shrio.dao;

import cn.baiyu.shrio.bean.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

/**
 * @auther baiyu
 * @date 2019/10/3
 */
public interface User2RoleDao extends JpaRepository<UserRole,Integer>, JpaSpecificationExecutor<UserRole>, Serializable {
    List<UserRole> findByUserId(Integer userid);
}
