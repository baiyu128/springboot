package cn.baiyu.controller;

import java.util.List;
import java.util.Optional;

import cn.baiyu.dao.UserDao;
import cn.baiyu.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * 测试类
 * @author baiyu
 *
 */
@RestController("/user")
@Slf4j
@Api(tags = "JPA 用户相关接口")
public class UserController {

	@Resource
	UserDao userDao;
	
	@PostMapping("/add")
	@ApiOperation(value = "新增", notes = "新增")
	public String addUser(User user) {
		log.info("新增用户:{}", user);
		user = userDao.save(user);
		return "新增成功，返回用户id为：" + user.getId();
	}
	
	@GetMapping("/find/{id}")
	@ApiOperation(value = "根据id查询", notes = "根据id查询")
	public User findUser(@PathVariable Long id) throws Exception {
		log.info("查找用户ID:{}", id);
		Optional<User> userOpl = userDao.findById(id);
		return userOpl.orElseThrow(() ->
				new Exception("查無 userInfo(dumdum) 資訊."));
	}
	
	@PostMapping("/del/{id}")
	@ApiOperation(value = "删除用户")
	public String delUser(Long id) {
		log.info("删除用户ID:{}", id);
		userDao.deleteById(id);
		return "用户id为：" + id + "，已被删除!";
	}
	
	@GetMapping("/find/{code}/{name}")
	@ApiOperation(value = "根据编码即名称查询")
	public List<User> findUserByCodeAndName(@PathVariable("code") String code, @PathVariable("name")String name) {
		log.info("命名规则方式，查找用户:编码：{}，名称：{}", code, name);
		return userDao.findByCodeAndName(code, name);
	}
	
	@GetMapping("/find/paging/{code}")
	@ApiOperation(value = "根据编码分页查询")
	public Page<User> findUserByCodePagin(@PathVariable("code") String code){
		log.info("分页模式，查找用户:编码：{}", code);
		//这里注意 page是从0开始的
		return userDao.findByCode(code, PageRequest.of(0,10));
	}
	
	@GetMapping("/find/sql/{code}")
	@ApiOperation(value = "根据编码查询")
	public List<User> findUserByQuerySql(@PathVariable("code") String code){
		log.info("自定义sql方式，查找用户:编码：{}", code);

		return userDao.queryByCode(code);
	}
}
