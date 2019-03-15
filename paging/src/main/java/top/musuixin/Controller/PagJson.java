package top.musuixin.Controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.musuixin.Mapper.InfoDao;
import top.musuixin.PoJo.InfoPolo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/PagJson")
public class PagJson {
    @Autowired
    InfoDao infoDao;

    @ResponseBody
    @RequestMapping("/getInfo")
    public List<InfoPolo> getInfo(@RequestParam(value = "num") int num) {
        System.out.println(num);
        PageHelper.startPage(num, 10);
        List<InfoPolo> infoPolos = infoDao.selectInfo();
        PageInfo pageInfo = new PageInfo(infoPolos);
        System.out.println(pageInfo.getPages());
        return infoPolos;
    }
    @ResponseBody
    @RequestMapping("/getPage")
    public HashMap<String,Integer> getPage() {
        PageHelper.startPage(1, 10);
        List<InfoPolo> infoPolos = infoDao.selectInfo();
        PageInfo pageInfo = new PageInfo(infoPolos);
        HashMap<String,Integer> map=new HashMap<>();
        map.put("totalPages", pageInfo.getPages());
        return map;
    }
}
