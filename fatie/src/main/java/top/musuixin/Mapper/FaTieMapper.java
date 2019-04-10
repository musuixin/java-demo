package top.musuixin.Mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.ShuJuPOJO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Repository
public interface FaTieMapper {
    @Select("select * from fatie order by time desc")
    List<ShuJuPOJO> getData();
    @Insert("insert into demo.fatie values (#{uname} ,#{text} ,#{time} )")
    void insterData(ShuJuPOJO shuJu);
}
