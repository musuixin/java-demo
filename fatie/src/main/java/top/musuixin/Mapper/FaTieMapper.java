package top.musuixin.Mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.ShuJuPOJO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Repository
public interface FaTieMapper {
    @Select("select * from fatie")
    LinkedList<ShuJuPOJO> getData();
    @Insert("insert into demo.fatie values (#{uname} ,#{text} ,#{time} )")
    void insterData(ShuJuPOJO shuJu);
}
