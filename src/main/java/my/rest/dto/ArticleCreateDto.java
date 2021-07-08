package my.rest.dto;

import my.rest.util.Constants;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ArticleCreateDto {
    @NotNull
    @Size(min = 1, max = 100)
    private String title;
    @NotNull
    private String author;
    @NotNull
    private String content;
    @NotNull
    @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT)
    private Date publishingDate;

    public ArticleCreateDto() {
    }

    public ArticleCreateDto(@NotNull @Size(min = 1, max = 100) String title, @NotNull String author, @NotNull String content,
                            @NotNull Date publishingDate) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.publishingDate = publishingDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }
}
