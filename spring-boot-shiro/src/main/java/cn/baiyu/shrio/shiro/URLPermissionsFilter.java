package cn.baiyu.shrio.shiro;

import cn.baiyu.shrio.bean.Permission;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class URLPermissionsFilter extends PermissionsAuthorizationFilter {

    /**
     *  @param mappedValue 指的是在声明url时指定的权限字符串，
     *  如/User/create.do=perms[User:create].我们要动态产生这个权限字符串，所以这个配置对我们没用
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean isAccessAllowed(ServletRequest request,
                                   ServletResponse response, Object mappedValue) throws IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = ((HttpServletRequest) request).getSession();

        if (req.getMethod().equals("OPTIONS")){
            return true;
        } else {
            String method = req.getMethod();
            String path = req.getServletPath();
            List<Permission> pLists =(List) session.getAttribute("permissionList");
            for (Permission pList : pLists) {
                // 当路径及方法匹配时放行
                if(path.matches(pList.getPermissionUrl())&& method.equals(pList.getMethod())){
                    return true;
                    // 该路径下的所有请求方法全部放行
                }else if (path.matches(pList.getPermissionUrl())&& "ALL".equals(pList.getMethod())){
                    return true;
                }
            }
            return false;
        }

    }


    /**
     * 根据请求URL产生权限字符串(如:/menu)，这里只产生，而比对的事交给Realm
     */
    protected String[] buildPermissions(ServletRequest request) {
        String[] perms = new String[1];
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getServletPath();
        perms[0] = path;//path直接作为权限字符串
        return perms;
    }
}