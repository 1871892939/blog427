package ncg.mapper;

import ncg.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
//    int deleteById(int id);
    Article getArticleById(Integer id);
}
