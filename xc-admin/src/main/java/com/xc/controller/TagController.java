package com.xc.controller;

import com.xc.domain.ResponseResult;
import com.xc.domain.dto.TagListDto;
import com.xc.domain.entity.Tag;
import com.xc.domain.vo.PageVo;
import com.xc.domain.vo.TagVo;
import com.xc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     *  分页查询标签
     * @param pageNum
     * @param pageSize
     * @param tagListDto
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        return tagService.pageTagList(pageNum,pageSize,tagListDto);
    }

    /**
     *  添加标签
     * @param addTag
     * @return
     */
    @PostMapping
    public ResponseResult addTag(@RequestBody Tag addTag){
        return tagService.addTag(addTag);
    }

    /**
     *  删除标签 逻辑删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteTag(@PathVariable("id") Long id){
        return tagService.deleteTagById(id);

    }

    /**
     *  获取要修改的标签信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getTag(@PathVariable("id") Long id){
        return tagService.getTagInfo(id);
    }

    /**
     *  修改标签信息
     * @param tag
     * @return
     */
    @PutMapping
    public ResponseResult updateTagInfo(@RequestBody Tag tag){
        return tagService.updateTagInfo(tag);
    }

    /**
     *  查询所有标签
     * @return
     */
    @GetMapping("/listAllTag")
    public ResponseResult listAllTag(){
        List<TagVo> list = tagService.listAllTag();
        return ResponseResult.okResult(list);
    }

}
