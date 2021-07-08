package my.rest.util;

import my.rest.dto.ArticleCreateDto;
import my.rest.dto.ArticleResponseDto;
import my.rest.model.Article;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class ArticleConverter {

    private ArticleConverter() {
    }

    public static Article articleCreateDtoToArticle(ArticleCreateDto articleCreateDto) {
        return new Article(articleCreateDto.getTitle(), articleCreateDto.getAuthor(), articleCreateDto.getContent(),
                articleCreateDto.getPublishingDate());
    }

    public static ArticleResponseDto articleToArticleResponseDto(Article article) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
        dateFormat.setTimeZone(timeZone);
        String publishingDateString = dateFormat.format(article.getPublishingDate());
        return new ArticleResponseDto(article.getTitle(), article.getAuthor(), article.getContent(), publishingDateString);
    }
}
