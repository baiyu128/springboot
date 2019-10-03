package cn.baiyu.shrio.dao;

import cn.baiyu.shrio.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.Optional;

/**
 * @auther baiyu
 * @date 2019/10/2
 */
public interface RoleDao extends JpaRepository<Role,Integer>, JpaSpecificationExecutor<Role>, Serializable {
}
