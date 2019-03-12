package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.name;

import java.util.LinkedList;

@Repository
public interface nameDao {
    @Select("select distinct Name label from info where Name like #{term} limit 5")
    LinkedList<name> SelectName(String term);
}
