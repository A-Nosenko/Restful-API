package my.rest.repository;

import my.rest.model.Article;
import my.rest.util.ArticleCopyUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Articles storage into memory, using ArrayList.
 */
public class ArticleRepository {

    private final List<Article> articles = new ArrayList<>();

    public boolean add(Article article) {
        return articles.add(article);
    }

    public boolean addAll(Collection<Article> articles) {
        return this.articles.addAll(articles);
    }

    /**
     * @return Return copy of articles storage, to prevent source list modifications.
     */
    public List<Article> getAll() {
        List<Article> result = new ArrayList<>();
        for (Article article : articles) {
            result.add(ArticleCopyUtil.copy(article));
        }
        return result;
    }
}
