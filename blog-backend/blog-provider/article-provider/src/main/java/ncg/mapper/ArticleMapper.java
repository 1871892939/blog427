package ncg.mapper;

import ncg.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    Integer insertArticle(Article article);

    //    int deleteById(int id);
    Article getArticleById(Integer id);

    List<Article> getAllArticle();

    Integer updateArticle(Article article);

    Integer deleteArticleById(Integer id);
}
