package cn.baiyu.shrio.controller;

import cn.baiyu.shrio.bean.User;
import cn.baiyu.shrio.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @auther baiyu
 * @date 2019/10/2
 */
@RequestMapping(value = "/users")
@RestController
@Api(tags = "用户")
public class UserController {

    @Resource
    private UserService userService;


    @ApiOperation(value = "查询所有用户")
    @RequestMapping(method = RequestMethod.GET)
    public List<User> list(HttpServletRequest request) {
        return userService.getAll();
    }

    @ApiOperation(value = "通过id查找用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User detail(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @ApiOperation(value = "新增用户")
    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @ApiOperation(value = "更新用户")
    @RequestMapping(method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequiresPermissions("删除") // 调用shiroRealm中doGetAuthorizationInfo方法
    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

}
