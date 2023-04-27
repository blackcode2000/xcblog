package com.xc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xc.domain.ResponseResult;
import com.xc.domain.dto.TagListDto;
import com.xc.domain.entity.Tag;
import com.xc.domain.vo.PageVo;
import com.xc.domain.vo.TagVo;

import java.util.List;


/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2023-04-20 19:26:37
 */
public interface TagService extends IService<Tag> {

    /**
     *  分页查询标签
     * @param pageNum
     * @param pageSize
     * @param tagListDto
     * @return
     */
    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);

    /**
     *  添加标签
     * @param addTag
     * @return
     */
    ResponseResult addTag(Tag addTag);

    /**
     *  删除标签
     * @param id
     * @return
     */
    ResponseResult deleteTagById(Long id);

    ResponseResult getTagInfo(Long id);

    ResponseResult updateTagInfo(Tag tag);

    List<TagVo> listAllTag();
}
