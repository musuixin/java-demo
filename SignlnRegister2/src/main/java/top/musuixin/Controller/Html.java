package top.musuixin.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * 用于返回视图
 * @date 3.24
 *
 * @author musuixin
 */
@Controller
public class Html {
    @RequestMapping("/Register")
    public String register() {
        return "Register";
    }

    @RequestMapping("/SignIn")
    public String signIn(@SessionAttribute(value = "code",required = false) Object code,HttpSession httpSession)
    {
        return "SignIn";
    }
    @RequestMapping("/success")
    public String success()
    {
        return "success/success";
    }
    @RequestMapping("/admain/index")
    public String admain()
    {
        return "admain/admain";
    }

}
