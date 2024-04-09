package cn.baiyu.shrio.shiro;

import cn.baiyu.shrio.bean.Permission;
import cn.baiyu.shrio.bean.Role;
import cn.baiyu.shrio.bean.User;
import cn.baiyu.shrio.service.PermissionService;
import cn.baiyu.shrio.service.RoleService;
import cn.baiyu.shrio.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;


/**
 * @auther baiyu
 * @date 2019/10/2
 */

public class ShiroRealm extends AuthorizingRealm {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 验证当前已登陆用户的权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (null == principalCollection){
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        logger.info("doGetAuthorizationInfo+"+principalCollection.toString());
        User user = userService.getByUserName((String) principalCollection.getPrimaryPrincipal());


        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()), SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //赋予角色
        for(Role userRole:roleService.getByUserId(user.getId())){
            info.addRole(userRole.getName());
            logger.info("获取角色信息："+userRole);
        }
        //赋予权限
        for(Permission permission:permissionService.getByUserId(user.getId())){
            info.addStringPermission(permission.getName());
                logger.info("获取权限信息："+permission.getName());
        }

        //设置登录次数、时间
//        userService.updateUserLogin(user);
        return info;
    }

    /**
     * 登陆时调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo +"  + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
        logger.info(userName+token.getPassword());
        if (userName == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        User user = userService.getByUserName(token.getUsername());
        if (user != null) {
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            session.setAttribute("permissionList", permissionService.getByUserId(user.getId()));
            return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
        } else {
            return null;
        }
    }

}
