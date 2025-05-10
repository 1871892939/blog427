package ncg.web.controller;

import lombok.extern.slf4j.Slf4j;
import ncg.pojo.Article;
import ncg.service.ArticleService;
import ncg.service.impl.ArticleServiceImpl;
import ncg_blog.common.web.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/getArticle")
@CrossOrigin(origins = "http://localhost:5174")
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticle() {
        return articleService.getAllArticle();
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable Integer id) {
        return articleService.getArticle(id);
    }

    @PostMapping
    @Transactional
    public Result addArticle(@RequestBody Article article) {
        int count = articleService.addArticle(article);
        System.out.println(article.toString());
        if (count > 0) {
            System.out.println("success");
            return Result.success(article);
        } else {
            System.out.println("fail");
            return Result.fail("不对");
        }
    }

    @PutMapping
    @Transactional
    public Result updateArticle(@RequestBody Article article) {
        if (article != null && articleService.getArticle(article.getId()) != null) {
            int count = articleService.updateArticle(article);
            if (count > 0) {
                return Result.success(article);
            } else {
                return Result.fail("修改失败");
            }
        } else {
//            System.out.println(articleService.getArticle(article.getId()));
            return Result.fail("文章传入失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result deleteArticle(@PathVariable Integer id) {
        try {
            int count = articleService.deleteArticleById(id);
            return count > 0 ? Result.success("删除成功") : Result.fail("删除失败");
        } catch (Exception e) {
            log.error("不存在的id{}", id, e);
            return Result.fail(e.getMessage());
        }
    }
}
