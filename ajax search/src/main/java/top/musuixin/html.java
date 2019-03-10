package top.musuixin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html/")
public class html {
    @RequestMapping("/index")
    public String index() {

        return "index";
    }
}
