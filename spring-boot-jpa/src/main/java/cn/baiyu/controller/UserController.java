package cn.baiyu.controller;

import java.util.List;
import java.util.Optional;

import cn.baiyu.UserNotExistException;
import cn.baiyu.dao.UserDao;
import cn.baiyu.entity.User;
import cn.baiyu.service.UserService;
import cn.baiyu.service.vo.PaginationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * 测试类
 * @author baiyu
 *
 */
@RestController
@RequestMapping("/test")
@Slf4j
@Api(tags = "JPA 用户相关接口")
public class UserController {

	@Resource
	private UserDao userDao;

	@Resource
	private UserService userService;
	
	@PostMapping("/user")
	@ApiOperation(value = "新增", notes = "新增")
	public User addUser(User user) {
		log.info("新增用户:{}", user);
		user = userDao.save(user);
		return user;
	}
	
	@GetMapping("/user/{id}")
	@ApiOperation(value = "根据id查询", notes = "根据id查询")
	public User findUser(@PathVariable Long id) throws Exception {
		log.info("查找用户ID:{}", id);
		Optional<User> userOpl = userDao.findById(id);
		return userOpl.orElseThrow(() ->
				new Exception("无该用户信息."));
	}
	
	@DeleteMapping("/user/{id}")
	@ApiOperation(value = "删除用户")
	public void delUser(Long id) {
		log.info("删除用户ID:{}", id);
		Optional<User> oU = userDao.findById(id);
		User user = oU.orElseThrow(UserNotExistException::new);
		user.setDeleted(true);
		userDao.save(user);
	}
	
	@GetMapping("/user/{code}/{name}")
	@ApiOperation(value = "根据编码即名称查询")
	public User findUserByCodeAndName(@PathVariable("code") String code, @PathVariable("name")String name) {
		log.info("命名规则方式，查找用户:编码：{}，名称：{}", code, name);
		return userDao.findByCodeAndName(code, name);
	}
	
	@GetMapping("/user/sql/{code}")
	@ApiOperation(value = "根据编码查询")
	public List<User> findUserByQuerySql(@PathVariable("code") String code){
		log.info("自定义sql方式，查找用户:编码：{}", code);

		return userDao.queryByCode(code);
	}

	@GetMapping("/user")
	@ApiOperation(value = "根据自定义条件分页查询")
	public PaginationVo<User> queryBySelf(@RequestParam(value = "用户名", required = false)String username,
										  @RequestParam(value = "昵称", required = false)String name,
										  @RequestParam(value = "编码", required = false)String code,
										  @RequestParam(value = "创建时间大于该时间的", required = false)String gmtCreate,
										  @RequestParam(value = "修改时间小于该时间的", required = false)String gmtModified,
										  @RequestParam(value = "页面大小")Integer pageSize,
										  @RequestParam(value = "当前页码")Integer current
								  ){
		return userService.queryBySelf(username, name, code, gmtCreate, gmtModified, pageSize,current);
	}
}
