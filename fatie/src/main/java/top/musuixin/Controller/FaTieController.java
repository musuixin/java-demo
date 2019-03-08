package top.musuixin.Controller;



import top.musuixin.PoJo.ShuJuPOJO;
import top.musuixin.Mapper.FaTieMapper;
import top.musuixin.Service.InsterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

@Controller
public class FaTieController {
   @Autowired
   InsterData insterData;
    @Autowired
    FaTieMapper faTieMapper;
    @RequestMapping("/fatie")
    public String faTie(){
        return "fatie";
    }
    @PostMapping("/tijiao")
    @ResponseBody
    public String tiJiao(@RequestParam(value = "uname") String uanme ,@RequestParam(value = "text",required = false) String text){
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
    public LinkedList<ShuJuPOJO> getData(){
        LinkedList<ShuJuPOJO> data = faTieMapper.getData();
        System.out.println(data);
        return data;
    }
}
