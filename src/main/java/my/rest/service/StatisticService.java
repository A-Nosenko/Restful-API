package my.rest.service;

import my.rest.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class StatisticService {

    private final ArticleRepository articleRepository;

    public StatisticService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Long getWeekCount() {
        Date now = new Date();
        Calendar startStatisticCalendar = Calendar.getInstance();
        startStatisticCalendar.setTime(now);
        startStatisticCalendar.add(Calendar.WEEK_OF_YEAR, -1);
        Date startStatisticDate = startStatisticCalendar.getTime();

        return articleRepository
                .getAll()
                .stream()
                .filter(article -> article.getPublishingDate().after(startStatisticDate)
                        && article.getPublishingDate().before(now))
                .count();
    }
}
