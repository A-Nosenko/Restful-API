package my.rest.config;

import my.rest.repository.ArticleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

@Configuration
public class AppConfig {

    @Bean
    @ApplicationScope
    public ArticleRepository articleRepositoryBean() {
        return new ArticleRepository();
    }
}
