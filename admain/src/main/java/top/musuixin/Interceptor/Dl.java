package top.musuixin.Interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author musuxin
 * @date 3.24
 * root 用户登录拦截
 */

public class Dl implements HandlerInterceptor {
    private final Logger logger = Logger.getLogger(Dl.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("root");
        if (user == null) {
            logger.info("没有登陆");
            response.sendRedirect("/admain_war_exploded/index");
            return false;
        }
        logger.info(user+"登陆了");
        return true;
    }
}
