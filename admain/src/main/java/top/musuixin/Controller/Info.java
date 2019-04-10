package top.musuixin.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Mapper.InfoDao;
import top.musuixin.PoJo.InfoPolo;
import top.musuixin.Service.Impl.InfoServiceimpl;

import java.util.HashMap;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-03-29 18:16
 * <p>
 * <p>
 * 用于restful api 风格的url设计
 */

@Controller
@CrossOrigin
@RequestMapping("/info")
public class Info {
    @Autowired
    InfoPolo infoPolo;

    @Autowired
    InfoDao infoDao;
    @Autowired
    InfoServiceimpl infoServiceimpl;

    @GetMapping("")
    @ResponseBody
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
    @PostMapping("")
    public void insertInfo(InfoPolo infoPolo) {
        infoServiceimpl.insertInfo(infoPolo);
    }

    @ResponseBody
    @DeleteMapping("/{ID}")
    public void deleteInfo(@PathVariable("ID") String id) {
        infoPolo.setID(id);
        System.out.println(infoPolo);
        infoServiceimpl.deleteInfo(infoPolo);
    }

    @ResponseBody
    @PutMapping("")
    public void putInfo(@RequestBody InfoPolo infoPolo) {
        System.out.println(infoPolo);
        infoServiceimpl.updateInfo(infoPolo);
    }

}
