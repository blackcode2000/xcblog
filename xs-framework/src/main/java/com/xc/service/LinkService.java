package com.xc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xc.domain.ResponseResult;
import com.xc.domain.entity.Link;
import com.xc.domain.vo.PageVo;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2023-03-24 16:13:45
 */
public interface LinkService extends IService<Link> {
    ResponseResult getAllLink();

    PageVo selectLinkPage(Link link, Integer pageNum, Integer pageSize);
}
