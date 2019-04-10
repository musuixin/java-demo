package top.musuixin.Service;


import org.springframework.stereotype.Service;
import top.musuixin.PoJo.NewsPojo;

import java.util.List;

@Service
public interface NewsService {
    List<NewsPojo> ShowstNewsList(int num, NewsPojo newsPojo);
    NewsPojo ShowNewsText(NewsPojo newsPojo);

}
