package ncg_blog.article_job.redis;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
public enum ArticleRedisKey {
    ARTICLE_HASH("articleHash:");
    ArticleRedisKey(String prefix, TimeUnit unit) {
        this.prefix = prefix;
        this.unit = unit;
    }


    ArticleRedisKey(String prefix) {
        this.prefix = prefix;
    }
    public String getRealKey(String key) {
        return this.prefix+key;
    }
    private String prefix;
    private TimeUnit unit;

}
