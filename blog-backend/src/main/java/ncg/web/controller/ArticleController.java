package ncg.web.controller;

import ncg.pojo.Article;
import ncg.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getArticle")
@CrossOrigin(origins = "http://localhost:5174")
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping
    public Article getArticle(Integer id) {
        return articleService.getArticle(id);
    }
}
