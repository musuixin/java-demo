package top.musuixin.Mapper;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.InfoPolo;

import java.util.LinkedList;
import java.util.List;

@Repository
@Mapper
public interface InfoDao {

    @Insert("insert into demo.info(Name, Education, Skill, IdealPost, WorkExperience, ExpectantCity) values (#{Name}  ,#{Education}  ,#{Skill} ,#{IdealPost} ,#{WorkExperience} ,#{ExpectantCity} )")
    void insertInfo(InfoPolo infoPolo);

    @Select("select * from info where ID=#{id}")
    List<InfoPolo> selectId(InfoPolo infoPolo);

    @Select("select * from info")
    List<InfoPolo> selectInfo();

    @Delete("delete from demo.info where ID=#{ID}")
    void deleteInfo(InfoPolo infoPolo);

    @Update("update demo.info set ExpectantCity=#{ExpectantCity} ," +
            "Skill=#{Skill} ,IdealPost=#{IdealPost} ,WorkExperience=#{WorkExperience}," +
            "Education=#{Education} where ID=#{ID} ")
    void updateInfo(InfoPolo infoPolo);
}
