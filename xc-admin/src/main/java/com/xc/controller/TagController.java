package com.xc.controller;

import com.xc.domain.ResponseResult;
import com.xc.domain.dto.TagListDto;
import com.xc.domain.entity.Tag;
import com.xc.domain.vo.PageVo;
import com.xc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto) {
        return tagService.pageTagList(pageNum, pageSize, tagListDto);
    }
    @PostMapping
    public ResponseResult addtag( Tag tag){
        return tagService.addtag(tag);
    }
    @PutMapping("{id}")
    public ResponseResult delTag(@PathVariable("id") Integer id){
        return tagService.delTag(id);
    }
}