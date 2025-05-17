package ncg.service.impl;

import ncg.mapper.ArticleMapper;
import ncg.pojo.Article;
import ncg.service.ArticleService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    //调优前 qps=6700 1000 10
    @Override
    public Article getArticle(Integer id) {
        System.out.println(id);
        return articleMapper.getArticleById(id);
    }

    @Override
    public List<Article> getAllArticle() {
//        System.out.println(articleMapper.getAllArticle());
        return articleMapper.getAllArticle();
    }

    @Override
    public int addArticle(Article article) {
        if (article.getDate() == null) {
            article.setDate(LocalDateTime.now());
        }
        return articleMapper.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public int deleteArticleById(Integer id) throws NotFoundException {
        if (getArticle(id) == null) {
            throw new NotFoundException("文章不存在");
        }

        return articleMapper.deleteArticleById(id);
    }
}
