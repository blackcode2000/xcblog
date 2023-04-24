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

    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);

    ResponseResult addtag(Tag tag);

    ResponseResult delTag(Integer id);

    ResponseResult updateTag(Long id);

    ResponseResult renewTag(Long id, String name, String remark);

    List<TagVo> listAllTag();
}
