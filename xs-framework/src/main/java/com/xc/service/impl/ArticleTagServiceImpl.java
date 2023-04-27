package com.xc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xc.domain.entity.ArticleTag;
import com.xc.mapper.ArticleTagMapper;
import com.xc.service.ArticleTagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章标签关联表(ArticleTag)表服务实现类
 *
 * @author makejava
 * @since 2023-04-24 17:28:18
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {
    @Override
    public List<Long> getTagList(Long id) {
        LambdaQueryWrapper<ArticleTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleTag::getArticleId, id);
        List<ArticleTag> articleTagList = list(queryWrapper);

        List<Long> tags = articleTagList
                .stream()
                .map(articleTag -> articleTag.getTagId())
                .collect(Collectors.toList());
        return tags;
    }
}
