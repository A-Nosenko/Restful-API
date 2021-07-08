package my.rest.service;

import my.rest.dto.ArticleCreateDto;
import my.rest.dto.ArticleResponseDto;
import my.rest.repository.ArticleRepository;
import my.rest.util.ArticleConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public boolean add(ArticleCreateDto articleCreateDto) {
        return articleRepository.add(ArticleConverter.articleCreateDtoToArticle(articleCreateDto));
    }

    public boolean addAll(Collection<ArticleCreateDto> articleCreateDtoCollection) {
        if (articleCreateDtoCollection == null) {
            return false;
        }

        return articleRepository.addAll(
                articleCreateDtoCollection
                        .stream()
                        .map(ArticleConverter::articleCreateDtoToArticle).collect(Collectors.toCollection(ArrayList::new))
        );
    }

    public Page<ArticleResponseDto> getAll(Pageable pageable) {

        List<ArticleResponseDto> articleResponseDtoTotalList = articleRepository
                .getAll()
                .stream()
                .map(ArticleConverter::articleToArticleResponseDto)
                .collect(Collectors.toCollection(ArrayList::new));

        List<ArticleResponseDto> articleResponseDtoResultList = new ArrayList<>();

        for (int i = 0; i < articleResponseDtoTotalList.size(); i++) {
            if (i > pageable.getOffset() && articleResponseDtoResultList.size() < pageable.getPageSize()) {
                articleResponseDtoResultList.add(articleResponseDtoTotalList.get(i));
            }
        }

        return new PageImpl<>(articleResponseDtoResultList, pageable, articleResponseDtoTotalList.size());
    }
}
