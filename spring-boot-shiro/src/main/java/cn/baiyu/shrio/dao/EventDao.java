package cn.baiyu.shrio.dao;

import cn.baiyu.shrio.bean.Event;
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
public interface EventDao extends JpaRepository<Event,Integer>, JpaSpecificationExecutor<Event>, Serializable {

    @Query(value = "select * from shiro_event where is_deleted=0", nativeQuery = true)
    List<Event> getAll();

    @Query(value = "select * from shiro_event where is_deleted=0 and id=?1", nativeQuery = true)
    Event getById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update shiro_event set is_deleted=1 where id=?1", nativeQuery = true)
    void delEvent(Integer id);
}
