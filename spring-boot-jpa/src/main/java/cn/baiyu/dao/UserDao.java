package cn.baiyu.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import cn.baiyu.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * 资源类
 * @author baiyu
 *
 */
public interface UserDao extends PagingAndSortingRepository<User,Long>, JpaSpecificationExecutor<User>, Serializable {

	Optional<User> findById(Long id);

	//使用自动命名规则进行查询服务 
	User findByCodeAndName(String code,String name);
	
	//使用@Query进行 自定义sql编写
	//nativeQuery=true,正常的sql语法
	//负责是hsql语法
	@Query(value="select * from jpa_user where code = ?1",nativeQuery=true)
	List<User> queryByCode(String code);
	
	//分页
	Page<User> findByCode(String code,Pageable pageable);
}