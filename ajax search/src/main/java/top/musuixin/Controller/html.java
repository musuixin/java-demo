package top.musuixin.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;

@Controller
@RequestMapping("/html")
public class html {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    @RequestMapping("/text/*")
    public String text() {
        return "text";
    }
}
