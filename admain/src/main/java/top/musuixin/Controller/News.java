package top.musuixin.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.jersey.api.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.musuixin.Mapper.NewsMapper;
import top.musuixin.PoJo.InfoPolo;
import top.musuixin.PoJo.NewsPojo;
import top.musuixin.Service.Impl.NewsServiceImpl;
import top.musuixin.Unitl.Upload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-01 09:33
 * <p>
 * 添加新闻内容
 */
@Controller
@PropertySource("classpath:config.properties")
@RequestMapping("/news")
@ResponseBody
public class News {
    @Value(value = "${ueditor}")    //后台图片保存地址
    private String ueditor;

    @Value(value = "${uploadHost}")
    private String uploadHost;    //项目host路径
    @Autowired
    NewsServiceImpl newsService;
    @Autowired
    NewsMapper newsMapper;
    @Autowired
    NewsPojo newsPojo;

    @PostMapping("")
    String addNews(NewsPojo newsPojo, @RequestParam("img") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        Client client = new Client();
        try {
            String uploadInfo = Upload.upload(client, file, request, response, uploadHost, ueditor);
            String[] infoList = uploadInfo.split(";");
            newsPojo.setFrontCover(infoList[2]);
        } catch (Exception e) {
            return "error";
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        newsPojo.setDate(dateStr);
        System.out.println(newsPojo);
        newsService.addNews(newsPojo);
        return "success";
    }
    @GetMapping("")
    @ResponseBody
    public HashMap<String, Object> getInfo(@RequestParam(value = "num") int num) {
        PageHelper.startPage(num, 10);
        HashMap<String, Object> hashMap = new HashMap<>();
        List<NewsPojo> newsPojos = newsMapper.selecctNews();
        PageInfo pageInfo = new PageInfo(newsPojos);
        hashMap.put("info", newsPojos);
        return hashMap;
    }
    @ResponseBody
    @DeleteMapping("/{ID}")
    public void deleteInfo(@PathVariable("ID") Long id) {
        newsPojo.setId(id);
        newsService.deleteNews(newsPojo);
    }

}
