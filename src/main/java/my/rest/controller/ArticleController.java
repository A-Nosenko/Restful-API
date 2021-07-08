package my.rest.controller;

import my.rest.dto.ArticleCreateDto;
import my.rest.dto.ArticleResponseDto;
import my.rest.dto.ResponseDto;
import my.rest.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseDto create(@RequestBody ArticleCreateDto articleCreateDto) {
        return new ResponseDto(null, articleService.add(articleCreateDto));
    }

    @PostMapping(value = "all")
    public ResponseDto createAll(@RequestBody List<ArticleCreateDto> articleCreateDtoList) {
        return new ResponseDto(null, articleService.addAll(articleCreateDtoList));
    }

    @GetMapping
    public ResponseDto<Page<ArticleResponseDto>> getAll(@PageableDefault Pageable pageable) {
        return new ResponseDto<>(articleService.getAll(pageable), true);
    }
}
