package top.musuixin.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.musuixin.Mapper.InfoDao;
import top.musuixin.Mapper.nameDao;
import top.musuixin.PoJo.InfoPolo;
import top.musuixin.PoJo.name;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Controller
@RequestMapping("/json")
public class json {
    @Autowired
    nameDao nameDao;
    @Autowired
    InfoDao infoDao;
    @RequestMapping("/info")
    @ResponseBody
    public LinkedList<name> info(@RequestParam("term") String term) {
        String name = "%" + term + "%";
        LinkedList<name> names = nameDao.SelectName(name);
        return names;
    }

    @RequestMapping("/search")
    @ResponseBody
    public HashMap<String,Object> search(@RequestParam("search") String search) {
        String searchs = "%" + search + "%";
        LinkedList<InfoPolo> infoPolos = infoDao.selectInfo(searchs);
        HashMap<String,Object> map=new HashMap<>();
        map.put("info",infoPolos);
        System.out.println(map);
        return map;
    }
}