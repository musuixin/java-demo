package top.musuixin;


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
    public HashMap<String, Object> getInfo(@RequestParam(value = "num") int num) {
        System.out.println(num);
        PageHelper.startPage(num, 10);
        HashMap<String, Object> hashMap = new HashMap<>();

        List<InfoPolo> infoPolos = infoDao.selectInfo();
        PageInfo pageInfo = new PageInfo(infoPolos);
        hashMap.put("info", infoPolos);
        System.out.println(pageInfo.getPages());
        return hashMap;
    }

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
}
