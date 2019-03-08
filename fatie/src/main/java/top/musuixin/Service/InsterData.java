package top.musuixin.Service;

import lombok.Data;
import org.springframework.stereotype.Service;
import top.musuixin.PoJo.ShuJuPOJO;
import top.musuixin.Mapper.FaTieMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Data
public class InsterData {
    @Autowired
    FaTieMapper faTieMapper=null;

    String uname;
    String text;
    String time;

    public void Sql(){
        ShuJuPOJO shuJuPOJO=new ShuJuPOJO();
        shuJuPOJO.setText(text);
        shuJuPOJO.setTime(time);
        shuJuPOJO.setUname(uname);
        faTieMapper.insterData(shuJuPOJO);
    }
}
