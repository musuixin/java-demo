package top.musuixin.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Mapper.NewsMapper;
import top.musuixin.PoJo.NewsPojo;
import top.musuixin.Service.NewsService;

import java.util.HashMap;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-02 21:50
 */

@Controller
@ResponseBody
@CrossOrigin
public class ShowNews {
    @Autowired
    NewsPojo newsPojo;
    @Autowired
    NewsService newsService;
    @RequestMapping("/showNewsList")
    public List<NewsPojo> getList(@RequestParam(value = "num") int num,NewsPojo newsPojo) {
        return newsService.ShowstNewsList(num,newsPojo);
    }
    @RequestMapping("/showNewsList/{id}")
    public NewsPojo getText(@PathVariable("id") int id) {
        newsPojo.setId(id);
        return newsService.ShowNewsText(newsPojo);
    }
}
