package top.musuixin.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.event.HierarchyBoundsListener;

/**
 *
 * 管理员拦截器
 *
 *
 * @author musuixin
 */

public class Admain implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("root");
        if(user==null){
            response.sendRedirect("/SignlnRegister2_war_exploded/SignIn");
            return false;
        }
        return true;
    }
}
