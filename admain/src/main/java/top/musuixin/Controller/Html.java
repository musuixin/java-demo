package top.musuixin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author musuixin
 * @date 2019-03-28 17:54
 */

@Controller
@RequestMapping("/admain")
public class Html {

    @RequestMapping("/admaininfo")
    String admaininfo() {
        return "admaininfo";
    }
    @RequestMapping("/table-basic")
    String tablebasic() {
        return "table-basic";
    }
    @RequestMapping("/news")
    String text() {
        return "news";
    }
    @RequestMapping("/news-table")
    String newstable(){
        return "news-table";
    }
}
