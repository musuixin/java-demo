package top.musuixin.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Mapper.InfoDao;
import top.musuixin.Mapper.NewsMapper;
import top.musuixin.PoJo.InfoPolo;
import top.musuixin.PoJo.NewsPojo;
import top.musuixin.Service.Impl.InfoServiceimpl;

import java.util.HashMap;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-03-28 18:04
 */
@Controller
@CrossOrigin
public class Json {
    @Autowired
    InfoDao userPoJo;
    @Autowired
    InfoDao infoDao;
    @Autowired
    InfoServiceimpl infoServiceimpl;
    @Autowired
    NewsMapper newsMapper;
    @ResponseBody
    @RequestMapping("/getPage")
    public HashMap<String, Integer> getPage() {
        PageHelper.startPage(1, 10);
        List<InfoPolo> infoPolos = infoDao.selectInfo();
        PageInfo pageInfo = new PageInfo(infoPolos);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("totalPages", pageInfo.getPages());
        return map;
    }
    @ResponseBody
    @RequestMapping("/getPageNews")
    public HashMap<String, Integer> getPageNews() {
        PageHelper.startPage(1, 10);
        List<NewsPojo> newsPojos = newsMapper.selecctNews();
        PageInfo pageInfo = new PageInfo(newsPojos);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("totalPages", pageInfo.getPages());
        return map;
    }




}
