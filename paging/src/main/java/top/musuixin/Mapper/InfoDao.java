package top.musuixin.Mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.InfoPolo;

import java.util.LinkedList;
import java.util.List;

@Repository
@Mapper
public interface InfoDao {
    @Select("select * from info")
    List<InfoPolo> selectInfo();
}
