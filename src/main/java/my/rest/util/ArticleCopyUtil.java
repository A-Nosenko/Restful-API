package my.rest.util;

import my.rest.model.Article;

public final class ArticleCopyUtil {

    private ArticleCopyUtil() {
    }

    public static Article copy(Article article) {
        return new Article(article.getTitle(), article.getAuthor(), article.getContent(), article.getPublishingDate());
    }
}
