package top.musuixin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.musuixin.PoJo.ShuJuPOJO;
import top.musuixin.Mapper.FaTieMapper;
import top.musuixin.Service.InsterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class FaTieController {
    @Autowired
    InsterData insterData;
    @Autowired
    FaTieMapper faTieMapper;

    @RequestMapping("/fatie")
    public String faTie() {
        return "fatie";
    }

    @PostMapping("/tijiao")
    @ResponseBody
    public String tiJiao(@RequestParam(value = "uname") String uanme, @RequestParam(value = "text", required = false) String text) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        insterData.setText(text);
        insterData.setTime(dateStr);
        insterData.setUname(uanme);
        insterData.Sql();
        return "success";
    }

    @ResponseBody
    @GetMapping("/getData")
    public  List<ShuJuPOJO> getData(int num) {
        PageHelper.startPage(num, 10);
        List<ShuJuPOJO> data = faTieMapper.getData();
        System.out.println(data);
        return data;
    }
    @ResponseBody
    @RequestMapping("/getPage")
    public HashMap<String, Integer> getPage() {
        PageHelper.startPage(1, 10);
        List<ShuJuPOJO> infoPolos = faTieMapper.getData();
        infoPolos.sort(Comparator.comparing(ShuJuPOJO::getTime).reversed());
        PageInfo pageInfo = new PageInfo(infoPolos);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("totalPages", pageInfo.getPages());
        return map;
    }
}
