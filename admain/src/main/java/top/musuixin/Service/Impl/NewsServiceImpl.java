package top.musuixin.Service.Impl;

import com.github.pagehelper.PageHelper;
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
    public void addNews(NewsPojo newsPojo) {
        newsMapper.addNews(newsPojo);
    }

    @Override
    public void selectNews(NewsPojo newsPojo) {
        List<NewsPojo> newsPojos = newsMapper.selecctNews();
    }

    @Override
    public void deleteNews(NewsPojo newsPojo) {
        System.out.println(newsPojo);
        newsMapper.deleteNews(newsPojo);
    }

    @Override
    public List<NewsPojo> selecctNews() {
        return newsMapper.selecctNews();
    }

    @Override
    public List<NewsPojo> ShowstNewsList(int num,NewsPojo newsPojo) {
        PageHelper.startPage(num, 10);
        List<NewsPojo> newsPojos = newsMapper.ShowstNewsList(newsPojo);
        return newsPojos;
    }

    @Override
    public NewsPojo ShowNewsText(NewsPojo newsPojo) {
        return newsMapper.ShowNewsText(newsPojo);
    }
}
