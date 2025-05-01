package ncg.service.impl;

import ncg.mapper.ArticleMapper;
import ncg.pojo.Article;
import ncg.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public Article getArticle(Integer id) {
        System.out.println(id);
        return articleMapper.getArticleById(id);
    }
}
