package my.rest.model;

import java.util.Date;

public class Article {
    private String title;
    private String author;
    private String content;
    private Date publishingDate;

    public Article() {
    }

    public Article(String title, String author, String content, Date publishingDate) {
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
