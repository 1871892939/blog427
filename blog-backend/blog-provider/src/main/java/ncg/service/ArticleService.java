package ncg.service;

import ncg.pojo.Article;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

public interface ArticleService {
    Article getArticle(Integer id);

    List<Article> getAllArticle();

    int addArticle(Article article);

//    boolean isAddArticle();
    int updateArticle(Article article);

    int deleteArticleById(Integer id) throws NotFoundException;
}
