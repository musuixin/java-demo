package top.musuixin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Mapper.UserMapper;
import top.musuixin.PoJo.UserPoJo;
import top.musuixin.Util.EncryptUtil;
import top.musuixin.Util.SendmailUtil;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;

/**
 * @author musuixin
 * @date 3.24
 * 注册逻辑
 *
 */
@Controller
public class RegisterJson {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserPoJo userPoJo;

    @PostMapping("/getCode")
    @ResponseBody
    public String code(String toEmail, HttpSession httpSession) {
        System.out.println(toEmail);
        int code = (int) (Math.random() * 1000000);
        SendmailUtil sendmailUtil = new SendmailUtil();
        sendmailUtil.setToemailECode(toEmail, code);
        sendmailUtil.start();
        httpSession.setAttribute("code", code);
        httpSession.setAttribute("email", toEmail);
        return "success";
    }

    @RequestMapping("/UnameCode")
    @ResponseBody
    public String unameCode(String upwd, String email,
                            String uname,
                            @RequestParam(value = "code", required = false) String code,
                            @SessionAttribute(value = "code", required = false) String recode,
                            @SessionAttribute(value = "email", required = false) String reemail) {
        userPoJo.setEmail(email);
        userPoJo.setUpwd(EncryptUtil.md5AndSha(upwd));
        userPoJo.setUname(uname);
        LinkedList<UserPoJo> userPoJos = userMapper.checkUname(userPoJo);
        if (userPoJos.isEmpty() && code.equals(recode)&&email.equals(reemail)) {
            userMapper.register(userPoJo);
            return "false";
        } else if (!userPoJos.isEmpty()) {
            return "true";
        }
        else if(reemail==null){
            return "true3";
        }
        else if(!email.equals(reemail)){
            return "true1";
        }
        else {
            return "true2";
        }
    }

    @RequestMapping("/Uname")
    @ResponseBody
    public String uname(String uname) {
        userPoJo.setUname(uname);
        LinkedList<UserPoJo> userPoJos = userMapper.checkUname(userPoJo);
        if (userPoJos.isEmpty()) {
            return "false";
        }
        return "true";
    }

    @RequestMapping("/Email")
    @ResponseBody
    public String email(String email) {
        userPoJo.setEmail(email);
        LinkedList<UserPoJo> userPoJos = userMapper.checkEmail(userPoJo);
        if (userPoJos.isEmpty()) {
            return "false";
        }
        return "true";
    }
}
