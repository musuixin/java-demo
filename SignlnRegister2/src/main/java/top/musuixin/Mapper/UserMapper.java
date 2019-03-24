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
    @Select("select * from user where uname=#{uname}  and upwd=#{upwd}")
    LinkedList<UserPoJo> login(UserPoJo userPoJo);

    @Insert("insert into user(uname,upwd,email) values (#{uname} ,#{upwd} ,#{email} )")
    int register(UserPoJo userPoJo);

    @Select("select * from user where uname=#{uname} ")
    LinkedList<UserPoJo> checkUname(UserPoJo userPoJo);

    @Select("select * from user where email=#{email}")
    LinkedList<UserPoJo> checkEmail(UserPoJo userPoJo);

    @Select("select id,uname,email from user")
    LinkedList<UserPoJo> getUserList();

    @Delete("delete from user where id =#{id}")
    int deleteUser(UserPoJo userPoJo);

}
