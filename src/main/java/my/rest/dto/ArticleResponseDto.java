package my.rest.dto;

public class ArticleResponseDto {
    private String title;
    private String author;
    private String content;
    private String publishingDate;

    public ArticleResponseDto() {
    }

    public ArticleResponseDto(String title, String author, String content, String publishingDate) {
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

    public String getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }
}
