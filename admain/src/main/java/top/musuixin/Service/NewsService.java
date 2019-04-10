package top.musuixin.Service;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import top.musuixin.PoJo.NewsPojo;

import java.util.List;

@Service
public interface NewsService {
    void addNews(NewsPojo newsPojo);
    void selectNews(NewsPojo newsPojo);
    void deleteNews(NewsPojo newsPojo);
    List<NewsPojo> selecctNews();
    List<NewsPojo> ShowstNewsList(int num,NewsPojo newsPojo);
    NewsPojo ShowNewsText(NewsPojo newsPojo);

}
