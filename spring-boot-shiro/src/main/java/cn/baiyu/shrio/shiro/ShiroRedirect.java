package cn.baiyu.shrio.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @auther baiyu
 * @date 2019/10/3
 */
public class ShiroRedirect extends FormAuthenticationFilter {
    private final String PREFLIGHT = "OPTIONS";

    public ShiroRedirect (){}

    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
        return ((HttpServletRequest)request).getMethod().equals(PREFLIGHT) ? true:super.isAccessAllowed(request, response, mappedValue);
    }
}
