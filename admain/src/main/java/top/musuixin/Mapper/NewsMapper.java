package top.musuixin.Mapper;

import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.InfoPolo;
import top.musuixin.PoJo.NewsPojo;

import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-01 16:46
 * <p>
 * ÐÂÎÅdao
 */

@Mapper
@Repository
public interface NewsMapper {
    @Insert("insert  into news(title, frontCover, date, author, plate, text) values (#{title} ,#{frontCover} ,#{date} ,#{author} ,#{plate} ,#{text} )")
    void addNews(NewsPojo newsPojo);
    @Select("select id, title,date, author, plate from news")
    List<NewsPojo> selecctNews();
    @Select("select id,frontCover,title,date, author, plate from news where plate=#{plate} ")
    List<NewsPojo> ShowstNewsList(NewsPojo newsPojo);
    @Select("select text from news where id=#{id}")
    NewsPojo ShowNewsText(NewsPojo newsPojo);
    @Delete("delete from news where id=#{id}")
    void deleteNews(NewsPojo newsPojo);
}
