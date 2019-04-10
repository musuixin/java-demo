package top.musuixin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import top.musuixin.Mapper.UserMapper;
import top.musuixin.PoJo.UserPoJo;
import top.musuixin.Util.EncryptUtil;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author musuixn
 * @date 3.24
 * 登陆逻辑
 *
 */
@Controller
public class SignInJson {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserPoJo userPoJo;
    @RequestMapping("/Login")
    @ResponseBody
    public String login(UserPoJo userPoJo, String upwd,HttpSession httpSession){
        userPoJo.setUpwd(EncryptUtil.md5AndSha(upwd));
        LinkedList<UserPoJo> login = userMapper.login(userPoJo);
        if(login.isEmpty()){
            return "error";
        }
        else {
            if(userPoJo.getUname().equals("root")){
                httpSession.setAttribute("root", userPoJo.getUname());
                return "rootsuccess";
            }
            httpSession.setAttribute("user", userPoJo.getUname());
           return "success";
        }
    }
    @RequestMapping("/dluser")
    @ResponseBody
    public HashMap<String,String> Dluser(@SessionAttribute("user") String user){
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("user",user);
        return hashMap;
    }
    @RequestMapping("/admain/getUserList")
    @ResponseBody
    public HashMap<String, LinkedList<UserPoJo>> getUserList(){
        LinkedList<UserPoJo> userList = userMapper.getUserList();
        HashMap<String, LinkedList<UserPoJo>> hashMap=new HashMap<>();
        hashMap.put("info",userList);
        return hashMap;
    }
    @RequestMapping("/admain/deleteUser")
    @ResponseBody
    public void deleteUser(UserPoJo userPoJo){
        int i = userMapper.deleteUser(userPoJo);
        System.out.println(i);
    }


}
