package top.musuixin.Interceptor;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @date 3.24
 *
 * root 用户登录拦截
 *
 * @author musuxin
 */

public class Dl implements HandlerInterceptor {
    private final  Logger logger = Logger.getLogger(Dl.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if(user==null){
            logger.info("没有登陆");
            response.sendRedirect("/SignlnRegister2_war_exploded/SignIn");
            return false;
        }
        logger.info("登陆了");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
