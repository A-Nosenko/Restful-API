package my.rest;

import my.rest.dto.ArticleCreateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getArticlesUnauthorised() throws Exception {

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            if (i > 10) {
                calendar.add(Calendar.WEEK_OF_YEAR, -i);
            }
            ArticleCreateDto articleCreateDto = new ArticleCreateDto(
                    "title_" + i,
                    "author_" + i,
                    "content_" + i,
                    calendar.getTime()
            );
            this.restTemplate.postForLocation("http://localhost:" + port + "/article", articleCreateDto);
        }

        String resultArticles = this.restTemplate
                .getForObject("http://localhost:" + port + "/article?page=3&size=10", String.class);

        System.out.println("\t\t\t>>> RESULT ARTICLES:");
        System.out.println(resultArticles);
        System.out.println("\t\t\t======================================================");

        assert resultArticles.contains("title_31");
        assert resultArticles.contains("content_31");

        assert resultArticles.contains("title_40");
        assert resultArticles.contains("author_40");
        assert resultArticles.contains("content_40");

        String resultStatistic = this.restTemplate.getForObject("http://localhost:" + port + "/statistic", String.class);

        System.out.println("\t\t\t>>> RESULT STATISTIC FORBIDDEN:");
        System.out.println(resultStatistic);
        System.out.println("\t\t\t======================================================");

        assert resultStatistic.contains("Forbidden");
    }

    @Test
    public void getArticlesAdmin() throws Exception {

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            if (i > 10) {
                calendar.add(Calendar.WEEK_OF_YEAR, -i);
            }
            ArticleCreateDto articleCreateDto = new ArticleCreateDto(
                    "title_" + i,
                    "author_" + i,
                    "content_" + i,
                    calendar.getTime()
            );
            this.restTemplate.postForLocation("http://localhost:" + port + "/article", articleCreateDto);
        }

        String resultStatistic = this.restTemplate
                .withBasicAuth("admin", "admin")
                .getForObject("http://localhost:" + port + "/statistic", String.class);

        System.out.println("\t\t\t>>> RESULT STATISTIC FORBIDDEN:");
        System.out.println(resultStatistic);
        System.out.println("\t\t\t======================================================");

        assert resultStatistic.contains("\"data\":11,\"success\":true");
    }
}
