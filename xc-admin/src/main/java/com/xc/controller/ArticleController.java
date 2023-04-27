package com.xc.controller;

import com.xc.domain.ResponseResult;
import com.xc.domain.dto.AddArticleDto;
import com.xc.domain.dto.AdminArticleDto;
import com.xc.domain.dto.ArticleDto;
import com.xc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content/article")
public class    ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article){
        return articleService.add(article);
    }

    /**
     * 查询博客列表
     *
     * @param pageNum    页面num
     * @param pageSize   页面大小
     * @param articleDto 文章dto
     * @return {@link ResponseResult}
     */
    @GetMapping("/list")
    public ResponseResult getAllArticleList(Integer pageNum, Integer pageSize, ArticleDto articleDto) {
        return articleService.getAllArticleList(pageNum, pageSize, articleDto);
    }

    /**
     *  修改文章：根据id获取文章详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getArticleById(@PathVariable("id") Long id) {
        return articleService.getArticleById(id);
    }

    /**
     *  修改文章: 更新文章
     * @param article
     * @return
     */
    @PutMapping
    public ResponseResult updateArticleById(@RequestBody AdminArticleDto article){

        return articleService.updateArticleInfo(article);
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteArticleById(@PathVariable("id") Long id){
        return articleService.deleteArticleById(id);
    }
}