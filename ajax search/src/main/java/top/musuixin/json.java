package top.musuixin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class json {
    @RequestMapping("/info")
    @ResponseBody
    public String info() {
        return "xxx";
    }
}
