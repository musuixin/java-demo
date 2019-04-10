package top.musuixin.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.NewsMapper;
import top.musuixin.PoJo.NewsPojo;
import top.musuixin.Service.NewsService;

import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-01 16:56
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;
    @Override
    public List<NewsPojo> ShowstNewsList(int num,NewsPojo newsPojo) {
        PageHelper.startPage(num, 10);
        List<NewsPojo> newsPojos = newsMapper.ShowstNewsList(newsPojo);
        PageInfo pageInfo=new PageInfo(newsPojos);
        for(NewsPojo newsPojo1:newsPojos){
            newsPojo1.setPage(pageInfo.getPages());
        }
        return newsPojos;
    }

    @Override
    public NewsPojo ShowNewsText(NewsPojo newsPojo) {
        return newsMapper.ShowNewsText(newsPojo);
    }
}
