package cn.baiyu.shrio.dao;

import cn.baiyu.shrio.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

/**
 * @auther baiyu
 * @date 2019/10/2
 */
public interface PermissionDao extends JpaRepository<Permission,Integer>, JpaSpecificationExecutor<Permission>, Serializable {

    @Query(value = "select p.* " +
            "from shiro_user u " +
            "LEFT JOIN shiro_user_role ur on u.id= ur.User_id " +
            "LEFT JOIN shiro_role r on ur.role_id=r.id " +
            "LEFT JOIN shiro_role_permission rp on rp.role_id=r.id " +
            "LEFT JOIN shiro_permission p on p.id =rp.permission_id " +
            "where u.id=?1", nativeQuery = true)
    List<Permission> getByUserId(Integer id);
}
