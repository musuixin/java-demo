package top.musuixin.Mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.UserPoJo;

import java.util.LinkedList;

/**
 * @author musuixin
 *
 * @date 3.27
 * user表操作Mapper
 *
 */

@Repository
@Mapper
public interface UserMapper {
    @Select("select * from user where email=#{email}   and upwd=#{upwd}")
    UserPoJo login(UserPoJo userPoJo);

}
