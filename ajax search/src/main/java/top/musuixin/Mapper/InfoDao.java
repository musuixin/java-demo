package top.musuixin.Mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.InfoPolo;

import java.util.LinkedList;

@Repository
@Mapper
public interface InfoDao {
    @Select("select * from info where NAME like #{search} ")
    LinkedList<InfoPolo> selectInfo(String search);

    @Select("select * from info where ID=#{id}   ")
    LinkedList<InfoPolo> selectId(int id);
}
