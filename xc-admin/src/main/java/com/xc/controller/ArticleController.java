package com.xc.controller;

import com.xc.domain.ResponseResult;
import com.xc.domain.dto.AddArticleDto;
import com.xc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article){
        return articleService.add(article);
    }
    @GetMapping("/list")
    public ResponseResult findArticle(Integer pageNum, Integer pageSize,String title,String summary){
        return articleService.findArticle(pageNum,pageSize,title,summary);
    }
    @GetMapping("{id}")
    public ResponseResult findById(@PathVariable("id") Long id){
        return articleService.findById(id);
    }
}