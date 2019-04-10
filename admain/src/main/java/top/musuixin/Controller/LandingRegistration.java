package top.musuixin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.musuixin.Mapper.UserMapper;
import top.musuixin.PoJo.UserPoJo;
import top.musuixin.Unitl.EncryptUtil;

import javax.servlet.http.HttpSession;

/**
 * @author musuixin
 * @date 2019-03-31 22:37
 */

@Controller


public class LandingRegistration {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/index")
    String index() {
        return "index";
    }
    @ResponseBody
    @PostMapping("/LandingRegistration")
    String Landing(UserPoJo userPoJo, HttpSession httpSession){
        if(!userPoJo.getRepwd().equals("*****")){
            return "fales";
        }
        userPoJo.setUpwd(EncryptUtil.md5AndSha(userPoJo.getUpwd()));
        UserPoJo login = userMapper.login(userPoJo);
        if(login==null){
            return "fales1";
        }
        httpSession.setAttribute("root",userPoJo.getEmail());
        return "true";
    }

}
