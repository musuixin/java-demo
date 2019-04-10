package top.musuixin;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.musuixin.Mapper.FaTieMapper;
import top.musuixin.PoJo.ShuJuPOJO;

import java.util.Comparator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class test {
    @Autowired
    FaTieMapper faTieMapper;

    @Test
    public void test(){
        List<ShuJuPOJO> data = faTieMapper.getData();

        System.out.println(data);
    }
}
